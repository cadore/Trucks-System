package br.com.cadoresistemas.williamcadore.Utils;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserSingleton {

    private Paths configClass = new Paths();
    private Random r = new Random();
    private Util date = new Util();

    public static String md5(String pwd){
            String password = "";
            MessageDigest md = null;
            try {
                    md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            }
            BigInteger hash = new BigInteger(1, md.digest(pwd.getBytes()));
            password = hash.toString(16);
            return password;
	}

    public boolean ValidUserSession(String login_user, String phone_user, String id_user) {
        if(configClass.getStatusUser(md5(login_user)) == false){
            String phone_user_ = phone_user.replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
            String first_num_phone = phone_user_.substring(0, 2);
            String last_num_phone = phone_user_.substring(7, 10);
            String cod = id_user + String.valueOf(r.nextInt(5678));
            String msg = "CadoreSistemas: Ola "+login_user+", o seu codigo de seguranca para acessar o sistema TrucksSystem e: "+cod+". \n ["
                    + date.getddMMyyyyHHmmss()+"]";
            date.sendSms(phone_user_, msg);
            //System.out.println(cod);
            JOptionPane.showMessageDialog(null, "É o primeiro acesso apartir deste computador usando o login: "+login_user+". \n"
                    + "Por motivo de segurança foi enviado um codigo para o seu celular, o código pode demorar até 5 minutos para chegar.\n"
                    + "Caso você não possui o celular em mãos ou não receber o código entre em contato com a CadoreSistemas.", "Cadore Sistemas", JOptionPane.INFORMATION_MESSAGE);
            JLabel label1 = new JLabel("Digite o código de segurança enviado para: ("+first_num_phone+") ****-*"+last_num_phone+".");
            JTextField jpf = new JTextField();
            JCheckBox jcb = new JCheckBox("Lembrar computador?");
            jcb.setSelected(true);
            jpf.grabFocus();
            int i1 = JOptionPane.showConfirmDialog(null, new Object[]{label1, jpf, jcb}, "Verificação de segurança.", JOptionPane.OK_CANCEL_OPTION);
                if(i1 == JOptionPane.OK_OPTION){
                    readmePC(jcb.isSelected());
                    if(cod.equals(jpf.getText().toUpperCase())){
                        return true;
                    }else{
                        return false;
                    }
                }else if(i1 == JOptionPane.CANCEL_OPTION){
                    System.exit(0);
                }
        }else{
          return true;
        }
        return false;
    }

    public boolean readme = false;

    public boolean readmePC(boolean readme_){
        if(readme_ == false){
            readme = false;
        }else if(readme_ == true){
            readme = true;
        }
        return false;
    }
}
