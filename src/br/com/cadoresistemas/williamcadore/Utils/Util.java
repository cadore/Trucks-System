package br.com.cadoresistemas.williamcadore.Utils;

import br.com.cadoresistemas.williamcadore.DAO.DriversDAO;
import br.com.cadoresistemas.williamcadore.DAO.TrucksDAO;
import br.com.cadoresistemas.williamcadore.DAO.UserDAO;
import br.com.cadoresistemas.williamcadore.DAO.UtilDAO;
import br.com.cadoresistemas.williamcadore.GUI.Dashboard;
import br.com.cadoresistemas.williamcadore.GUI.LoginForm;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

public class Util extends PlainDocument{

    /* Inicio da Classe Datas */
    public String getddMMyyyyHHmmss() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String getDateddMMyyyy() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String getDateyyyyMMdd() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String getDateyyyyddMM() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String getDateyyyy() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String getDatedd() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("dd");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String getDateMM() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("MM");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String getHorHHmmss() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String getHorss() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("ss");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public String dateFormatReturn(Date date) throws ParseException{
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date2);
    }

    public java.util.Date dateFormatInsert(String date) throws ParseException{
        Date sdf = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        return sdf;
    }

    public java.sql.Date dateFormatInsertSql(Date date){
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public boolean isYearBissextile(int  ano) {
        if((ano % 4 == 0 && ano % 100 != 0 ) || (ano % 400 == 0)){
            return true;
        }
        else{
            return false;
        }
   }

    public boolean isValidDate(String dateStr){
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(df.parse(dateStr));
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
            String[] data = dateStr.split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];
            if ( (new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue() ) {
                return(false);
            } else if ( (new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH)+1)).intValue() ) {
                return(false);
            } else if ( (new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue() ) {
                return(false);
            }
            return(true);
        }

    public boolean isValidYear(String year){
            DateFormat df = new SimpleDateFormat("yyyy");
            Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(df.parse(year));
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ( (new Integer(year)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue() ) {
                return(false);
            }
            return(true);
        }

    public boolean isValidMonth(String month){
            DateFormat df = new SimpleDateFormat("MM");
            Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(df.parse(month));
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ( (new Integer(month)).intValue() != (new Integer(cal.get(Calendar.MONTH)+1)).intValue() ) {
            return(false);
        }
        return(true);
        }

    public boolean isValidDay(String day){
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = new GregorianCalendar();
        try {
            cal.setTime(df.parse(day));
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ( (new Integer(day)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue() ) {
            return(false);
        }
        return(true);
    }

    /* Fim da Classe Datas */

    String directory_separator = java.io.File.separator;

    public boolean isValidCpf(String str_cpf) { // formato XXX.XXX.XXX-XX
        str_cpf = str_cpf.replace(".", "");
        str_cpf = str_cpf.replace("-", "");
        if (str_cpf.equals("00000000000") || str_cpf.equals("11111111111") || str_cpf.equals("22222222222") || str_cpf.equals("33333333333")
                || str_cpf.equals("44444444444") || str_cpf.equals("55555555555") || str_cpf.equals("66666666666") || str_cpf.equals("77777777777")
                || str_cpf.equals("88888888888") || str_cpf.equals("99999999999")) {
            return false;
        } else {
            System.out.println(str_cpf);
            if (!str_cpf.substring(0, 1).equals("")) {
                try {
                    boolean validado = true;
                    int d1, d2;
                    int digito1, digito2, resto;
                    int digitoCPF;

                    String nDigResult;
                    d1 = d2 = 0;
                    digito1 = digito2 = resto = 0;

                    for (int nCount = 1; nCount < str_cpf.length() - 1; nCount++) {
                        digitoCPF = Integer.valueOf(str_cpf.substring(nCount - 1, nCount)).intValue();

                        //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                        d1 = d1 + (11 - nCount) * digitoCPF;

                        //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                        d2 = d2 + (12 - nCount) * digitoCPF;
                    }

                    //Primeiro resto da divisão por 11.
                    resto = (d1 % 11);

                    //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
                    if (resto < 2) {
                        digito1 = 0;
                    } else {
                        digito1 = 11 - resto;
                    }

                    d2 += 2 * digito1;

                    //Segundo resto da divisão por 11.
                    resto = (d2 % 11);

                    //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
                    if (resto < 2) {
                        digito2 = 0;
                    } else {
                        digito2 = 11 - resto;
                    }

                    //Digito verificador do CPF que está sendo validado.
                    String nDigVerific = str_cpf.substring(str_cpf.length() - 2, str_cpf.length());

                    //Concatenando o primeiro resto com o segundo.
                    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

                    //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
                    return nDigVerific.equals(nDigResult);

                } catch (Exception e) {
                    System.err.println("Erro! " + e);

                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public boolean isValidCnpj(String str_cnpj) {
        str_cnpj = str_cnpj.replace(".", "");//onde há ponto coloca espaço
        str_cnpj = str_cnpj.replace("/", "");//onde há barra coloca espaço
        str_cnpj = str_cnpj.replace("-", "");//onde há traço coloca espaço
        if (str_cnpj.equals("00000000000000") || str_cnpj.equals("11111111111111") || str_cnpj.equals("22222222222222") || str_cnpj.equals("33333333333333")
                || str_cnpj.equals("44444444444444") || str_cnpj.equals("55555555555555") || str_cnpj.equals("66666666666666") || str_cnpj.equals("77777777777777")
                || str_cnpj.equals("88888888888888") || str_cnpj.equals("99999999999999")) {
            return false;
        } else {
            System.out.println(str_cnpj);
            if (!str_cnpj.substring(0, 1).equals("")) {
                try {
                    int soma = 0, dig;
                    String cnpj_calc = str_cnpj.substring(0, 12);

                    if (str_cnpj.length() != 14) {
                        return false;
                    }
                    char[] chr_cnpj = str_cnpj.toCharArray();
                    /* Primeira parte */
                    for (int i = 0; i < 4; i++) {
                        if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                            soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                        }
                    }
                    for (int i = 0; i < 8; i++) {
                        if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                            soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                        }
                    }
                    dig = 11 - (soma % 11);
                    cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                            dig);
                    /* Segunda parte */
                    soma = 0;
                    for (int i = 0; i < 5; i++) {
                        if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                            soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                        }
                    }
                    for (int i = 0; i < 8; i++) {
                        if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                            soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                        }
                    }
                    dig = 11 - (soma % 11);
                    cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                            dig);
                    return str_cnpj.equals(cnpj_calc);
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public void sendSms(String phone, String msg){
        try {
            String urlParameters = "user=cadore" +
                                        "&password=a1s2d3f4cadore()" +
                                        "&destinatario=" + phone +
                                        "&msg=" + URLEncoder.encode(msg, "UTF-8");;

            URL url = new URL("http://www.facilitamovel.com/api/simpleSend.ft?");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            connection.setUseCaches (false);

            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(urlParameters);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer strRet = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                    strRet.append(line);
            }
            wr.close();
            rd.close();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public boolean isValidLoginDB(String login){
        if(login.equals(new UserDAO().getLoginsUser(login))){
            return false;
        }
        return true;
     }

     public boolean isValidCpfDB(String cpf){
        if(cpf.equals(new DriversDAO().getCpfDrivers(cpf))){
            return false;
        }
        return true;
     }

     public boolean isValidN_truckDB(Long n_truck, Long id_business){
         if(n_truck.equals(new TrucksDAO().getN_truckisValidDB(n_truck, Long.valueOf(id_business)))){
             return false;
         }else{
             return true;
         }
     }

     public boolean isValidBoardTruckDB(String board){
        if(board.equals(new TrucksDAO().getBoardTruckisValidDB(board))){
            return false;
        }else{
            return true;
        }
     }

     public boolean isValidN_renavamTruckDB(String n_renavam){
        if(n_renavam.equals(new TrucksDAO().getN_renavamTruckisValidDB(n_renavam))){
            return false;
        }else{
            return true;
        }
     }

     public boolean isValidN_chassiTruckDB(String n_chassi){
        if(n_chassi.equals(new TrucksDAO().getN_chassiTruckisValidDB(n_chassi))){
            return false;
        }else{
            return true;
        }
     }

     public void getVersionSystem() throws IOException{
         String actualVersion = TrucksSystemDefault.actual_version;
         String version = new UtilDAO().getVersion();
         if(!actualVersion.equals(version)){
            Process pro = null;
            String d = System.getProperty("user.dir");
            pro = Runtime.getRuntime().exec("cmd.exe /c "+d+"/UpdateTrucksSystem.jar "+actualVersion+" "+version+" TRUE");
            System.exit(0);
         }else if(TrucksSystemDefault.actual_version.equals(new UtilDAO().getVersion())){
            LoginForm login = new LoginForm();
            URL url = login.getClass().getResource("/Images/iconTruckSystem.jpg");
            Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
            login.setIconImage(iconeTitulo);
            login.setVisible(true);
            login.toFront();
         }else{
             JOptionPane.showMessageDialog(null, "Não foi possivel iniciar o sistemas, tente novamente!", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
             System.exit(0);
         }
     }

     public boolean isNumbers(JTextField jtf) {
         if("".equals(jtf.getText())){
                    return false;
         }
         String valor = jtf.getText();
		final String NUMEROS = "0123456789.,";
		for (int i = 0; i < valor.length(); i++) {
			char caracter = valor.charAt(i);
			if(NUMEROS.indexOf(caracter) == -1) {
				return false;
			}
		}
		return true;
	}

     public boolean isBiggerAge(Date birthday, Date date_db){
        Calendar c = new GregorianCalendar();
        c.setTime(date_db);
        c.add(Calendar.YEAR, -18);
        Date date = dateFormatInsertSql(c.getTime());
        int a = date.compareTo(birthday);
        if(a == 1 || a == 0){
            return true;
        }else if(a != 1 && a != 0){
            return false;
        }
        return false;
     }
}