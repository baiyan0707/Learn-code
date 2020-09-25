package blog.baiyan.github.excel.poiexcel.utils;

import blog.baiyan.github.excel.poiexcel.dto.UserHealthInfoDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author bai
 * @Description
 * @Date 2020/8/7 1:48 PM
 */
public class ExcelUtil {
    private static Logger log = Logger.getLogger(String.valueOf(ExcelUtil.class));

    private final static String excel2003L = ".xls"; // 2003- 版本的excel
    private final static String excel2007U = ".xlsx"; // 2007+ 版本的excel

    /**
     * 将流中的Excel数据转成List<Map>
     *
     * @param in       输入流
     * @param fileName 文件名（判断Excel版本）
     * @return
     * @throws Exception
     */
    public static List<UserHealthInfoDTO> parseExcel(InputStream in, String fileName) throws Exception {
        // 根据文件名来创建Excel工作薄
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        // 返回数据
        List<UserHealthInfoDTO> allList = new ArrayList<>();
        // 遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            // 取第一行标题
            row = sheet.getRow(0);
            String title[] = null;
            if (row != null) {
                title = new String[row.getLastCellNum()];
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    title[y] = (String) getCellValue(cell);
                }
            } else {
                continue;
            }
            // 遍历当前sheet中的所有行
            for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
                row = sheet.getRow(j);
                if (!getCellValue(row.getCell(0)).equals("")) {
                    UserHealthInfoDTO sjbcExcelDTO = new UserHealthInfoDTO();
                    // 遍历所有的列
                    for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                        cell = row.getCell(y);
                        String key = title[y];
                        if (key.equals("序号") && !getCellValue(cell).equals("")) {
                            sjbcExcelDTO.setTitel(getCellValue(cell));
                        }
                        if (key.equals("年份") && !getCellValue(cell).equals("")) {
                            sjbcExcelDTO.setYear(getCellValue(cell));
                        }
                        if (key.equals("预约号") && !getCellValue(cell).equals("")) {
                            sjbcExcelDTO.setOrderNumber(getCellValue(cell));
                        }
                        if (key.equals("性别") && !getCellValue(cell).equals("")) {
                            sjbcExcelDTO.setGender(getCellValue(cell));
                        }
                        if (key.equals("年龄") && !getCellValue(cell).equals("")) {
                            sjbcExcelDTO.setAge(getCellValue(cell));
                        }
                        if (key.equals("项目组合") && !getCellValue(cell).equals("")) {
                            sjbcExcelDTO.setProject(getCellValue(cell));
                        }
                        if (key.equals("体检项目") && !getCellValue(cell).equals("")) {
                            sjbcExcelDTO.setExamProject(getCellValue(cell));
                        }
                        if (key.equals("体检结果") && !getCellValue(cell).equals("")) {
                            sjbcExcelDTO.setResult(getCellValue(cell));
                        }
                    }
                    allList.add(sjbcExcelDTO);                }
            }
        }
        work.close();
        return allList;
    }

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     *
     * @param inStr ,fileName
     * @return
     * @throws Exception
     */
    public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(inStr); // 2003-
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(inStr); // 2007+
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 描述：对表格中数值进行格式化
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        String value = null;
        DecimalFormat df = new DecimalFormat("0"); // 格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // 日期格式化
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DecimalFormat df2 = new DecimalFormat("0"); // 格式化数字

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = df.format(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = sdf.format(cell.getDateCellValue());
                } else {
                    //Sun Dec 31 15:03:00 CST 1899格式化时间15:03
                    value = sdf2.format(cell.getDateCellValue()).substring(11, 16);
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                //value = cell.getBooleanCellValue();
                value = "";
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("");
        FileInputStream fis = new FileInputStream(file);
        List<UserHealthInfoDTO> ls = parseExcel(fis, file.getName());
        ls.forEach(System.out::println);
        System.out.println("总数据大小为: " + ls.size());
    }
}
