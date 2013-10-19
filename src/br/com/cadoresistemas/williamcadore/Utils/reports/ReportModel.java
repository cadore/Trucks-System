package br.com.cadoresistemas.williamcadore.Utils.reports;


import br.com.cadoresistemas.williamcadore.ConnectioFactory.ConnectionFactory;
import br.com.cadoresistemas.williamcadore.GUI.Dashboard;
import br.com.cadoresistemas.williamcadore.Utils.Paths;
import br.com.cadoresistemas.williamcadore.Utils.SendMail;
import br.com.cadoresistemas.williamcadore.Utils.Util;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class ReportModel {

    private Util ut = new Util();

    public static void openReport(String titulo, InputStream inputStream, Map parametros, Connection conexao) throws JRException{
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao);
        viewReportFrame(titulo, print);

    }

    public static void openReport(String titulo, InputStream inputStream, Map parametros, JRDataSource dataSource) throws JRException{
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, dataSource);
        viewReportFrame(titulo, print);
    }

    private static void viewReportFrame(String titulo, JasperPrint print) {
        JRViewer viewer = new JRViewer(print);
        JFrame frameRelatorio = new JFrame(titulo);
        frameRelatorio.add(viewer, BorderLayout.CENTER);
        frameRelatorio.setSize(500, 500);
        frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH );
        frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        frameRelatorio.setVisible(true);
        URL url = frameRelatorio.getClass().getResource("/Images/iconTruckSystem.jpg");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        frameRelatorio.setIconImage(iconeTitulo);
    }

    public void sendReportToMail(InputStream inputStream, Map<String, Object> parametros,String description , Dashboard dash){
        JLabel l1 = new JLabel("Digite o e-mail que será enviado.");
        JTextField j1 = new JTextField("");
        int i1 = JOptionPane.showConfirmDialog(null, new Object[]{l1,j1}, "Usuários", JOptionPane.OK_CANCEL_OPTION);
        if(i1 == JOptionPane.OK_OPTION){
            try {
                String path_pdf = new Paths().getDirectoryPDFReportTemp()+"\\temp_report.pdf";
                String time = ut.getDateddMMyyyy()+" "+ut.getHorHHmmss();
                JasperPrint impressao = JasperFillManager.fillReport(inputStream, parametros, ConnectionFactory.getConnection(1));
                JasperExportManager.exportReportToPdfFile(impressao, path_pdf);
                new SendMail().sendMail(j1.getText(), "Relatório de "+description+" | Cadore Sistemas",
                    "Segue em anexo o relatório de "+description+". \nGerado em "+time+" enviado por "+dash.user.getFullName()+" - "+dash.user.getLogin()+"\n\n",
                    1, path_pdf, "Relatório | "+description, "Relatorio | "+description +".pdf");
                JOptionPane.showMessageDialog(null, "E-Mail enviado com sucesso.",
            "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
            } catch (JRException ex) {
                Logger.getLogger(ReportModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}