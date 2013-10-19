package br.com.cadoresistemas.williamcadore.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Paths {

       private String string_limit_results = "25";
       private String directory_separator = java.io.File.separator;

       private String directory_file_limit_results = "C:"+directory_separator+"Users"+directory_separator+System.getProperty("user.name") + directory_separator
               + "AppData" + directory_separator + "Roaming" + directory_separator + ".trucks_system"+ directory_separator + "config" + directory_separator
               + "limit_results";

       private String directory_file_user = "C:"+directory_separator+"Users"+directory_separator+System.getProperty("user.name") + directory_separator
               + "AppData" + directory_separator + "Roaming" + directory_separator + ".trucks_system"+ directory_separator + "db" + directory_separator +
               "status" + directory_separator + "users";

       private String directory_file_actual_version = "C:"+directory_separator+"Users"+directory_separator+System.getProperty("user.name") + directory_separator
               + "AppData" + directory_separator + "Roaming" + directory_separator + ".trucks_system"+ directory_separator + "system" + directory_separator +
               "version";

       private String directory_file_report_temp = "C:"+directory_separator+"Users"+directory_separator+System.getProperty("user.name") + directory_separator
               + "AppData" + directory_separator + "Roaming" + directory_separator + ".trucks_system"+ directory_separator + "temp" + directory_separator +
               "reports";

    public String getConfigLimitResults(){
            try {
                if (!new File(directory_file_limit_results + directory_separator + "limit_general_results.txt").exists()) {
                    string_limit_results = "25";
                    }else{
              FileReader arq = new FileReader(directory_file_limit_results + directory_separator + "limit_general_results.txt");
              BufferedReader lerArq = new BufferedReader(arq);

              string_limit_results = lerArq.readLine();
              arq.close();
                }
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                  e.getMessage());
            }
            return string_limit_results;
       }

    public void setConfigLimitResults(String limit_results) throws IOException{
        try {
            try {
                 if (!new File(directory_file_limit_results).exists()) { // Verifica se o diretório existe.
                     (new File(directory_file_limit_results)).mkdirs();   // Cria o diretório
                 }
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"Err","Erro ao criar o diretório" + ex.toString(),JOptionPane.ERROR_MESSAGE);
            }

            // Gravando no arquivo
            File arquivo_txt;
            arquivo_txt = new File(directory_file_limit_results + directory_separator + "limit_general_results.txt");
            try (FileOutputStream fos = new FileOutputStream(arquivo_txt, false)) {
                fos.write(limit_results.getBytes());
            }
            /* Lendo do arquivo
            */
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public boolean getStatusUser(String login_user){
                if (new File(directory_file_user + directory_separator + login_user+".txt").exists()) {
                    return true;
                }else{
                    return false;
             }
    }

    public void setStatusUser(String login_user){
        try {
            try {
                 if (!new File(directory_file_user).exists()) { // Verifica se o diretório existe.
                     (new File(directory_file_user)).mkdirs();   // Cria o diretório
                 }
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"Erro","Erro ao criar o diretório" + ex.toString(),JOptionPane.ERROR_MESSAGE);
            }
            File arquivo_txt;
            arquivo_txt = new File(directory_file_user + directory_separator + login_user+".txt");
            try (FileOutputStream fos = new FileOutputStream(arquivo_txt, false)) {
                fos.write("".getBytes());
            }
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public void deleteStatusUser(String login_user){
        new File(directory_file_user + directory_separator + login_user+".txt").delete();
    }

    public void setActualVersionSystem(String actual_version){
        try {
            try {
                 if (!new File(directory_file_actual_version).exists()) { // Verifica se o diretório existe.
                     (new File(directory_file_actual_version)).mkdirs();   // Cria o diretório
                 }
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"Erro","Erro ao criar o diretório" + ex.toString(),JOptionPane.ERROR_MESSAGE);
            }
            File arquivo_txt;
            arquivo_txt = new File(directory_file_actual_version + directory_separator + "version.txt");
            try (FileOutputStream fos = new FileOutputStream(arquivo_txt, false)) {
                fos.write(actual_version.getBytes());
            }
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public String getDirectoryPDFReportTemp(){
        try {
            try {
                 if (!new File(directory_file_report_temp).exists()) { // Verifica se o diretório existe.
                     (new File(directory_file_report_temp)).mkdirs();   // Cria o diretório
                 }
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,"Err","Erro ao criar o diretório" + ex.toString(),JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
        return directory_file_report_temp;
    }
}
