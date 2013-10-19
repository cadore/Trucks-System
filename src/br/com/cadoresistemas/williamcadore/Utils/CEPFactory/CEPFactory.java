package br.com.cadoresistemas.williamcadore.Utils.CEPFactory;

import br.com.cadoresistemas.williamcadore.Utils.TrucksSystemDefault;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CEPFactory {

    public CEPFactory SearchCep(String cepSearch){
        try {
            URL url = null;
            HttpURLConnection con = null;
            BufferedReader in = null;
            StringBuilder linha = new StringBuilder();
                url = new URL("http://www.correios.com.br/enderecador/requisicao/xmlPesquisa.cfm?cep=" + cepSearch + "&chave="+getCod());
                con = (HttpURLConnection)url.openConnection();
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while((inputLine = in.readLine()) != null)
                {
                    inputLine = inputLine.trim();
                    linha.append(inputLine);
                }
                in.close();
                codError = -1;
                String startTag = "<Versao>";
                String endTag = "</Versao>";
                int start = linha.indexOf(startTag) + startTag.length();
                int end = linha.indexOf(endTag);
                startTag = "<CodMensagem>";
                endTag = "</CodMensagem>";
                start = linha.indexOf(startTag) + startTag.length();
                end = linha.indexOf(endTag);
                codError = Integer.parseInt(linha.substring(start, end));
                if(codError == 1){
                    startTag = "<Logradouro>";
                    endTag = "</Logradouro>";
                    start = linha.indexOf(startTag) + startTag.length();
                    end = linha.indexOf(endTag);
                    setAddress(linha.substring(start, end));
                    startTag = "<Bairro>";
                    endTag = "</Bairro>";
                    start = linha.indexOf(startTag) + startTag.length();
                    end = linha.indexOf(endTag);
                    setDistrict(linha.substring(start, end));
                    startTag = "<Cidade>";
                    endTag = "</Cidade>";
                    start = linha.indexOf(startTag) + startTag.length();
                    end = linha.indexOf(endTag);
                    setCity(linha.substring(start, end));
                    startTag = "<UF>";
                    endTag = "</UF>";
                    start = linha.indexOf(startTag) + startTag.length();
                    end = linha.indexOf(endTag);
                    setUf(linha.substring(start, end));
                    setCep(cepSearch);
                }
        } catch (IOException ex) {
            Logger.getLogger(CEPFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }



    public String getCod()
    {
        return TrucksSystemDefault.cod_correios;
    }

    public void setCod(String cod)
    {
        this.cod = cod;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city
)    {
        this.city = city;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getUf()
    {
        return uf;
    }

    public void setUf(String uf)
    {
        this.uf = uf;
    }

    public String getCep()
    {
        return cep;
    }

    public void setCep(String cep)
    {
        this.cep = cep;
    }

    private String district;
    private String city;
    private String address;
    private String uf;
    private String cep;
    private String cod;
    private int codError;
}
