package br.com.cadoresistemas.williamcadore.Utils;

import br.com.cadoresistemas.williamcadore.DAO.UserDAO;
import br.com.cadoresistemas.williamcadore.ModelsForm.UserModel;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcel {
    public void expExcel() {

HSSFWorkbook workbook = new HSSFWorkbook();
HSSFSheet firstSheet = workbook.createSheet("Aba1");

FileOutputStream fos = null;

String nomeArquivo = "C:/root/teste.xls";

try {
fos = new FileOutputStream(new File(nomeArquivo));

int i = 0;

List<UserModel> users = new UserDAO().getUsers(Long.valueOf(1));

for (UserModel users_ : users) {
HSSFRow row = firstSheet.createRow(i);

row.createCell(0).setCellValue(users_.getFullName());
row.createCell(1).setCellValue(users_.getLogin());
row.createCell(2).setCellValue(users_.getContact());
row.createCell(3).setCellValue(users_.getAdmin());

i++;

} // fim do for

workbook.write(fos);

} catch (Exception e) {
e.printStackTrace();
System.out.println("Erro ao exportar arquivo");
} finally {
try {
fos.flush();
fos.close();
} catch (Exception e) {
e.printStackTrace();
}
}
} // fim do metodo exp
}
