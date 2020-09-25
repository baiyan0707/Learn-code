package blog.baiyan.github.excel.easyexcel.util;

import blog.baiyan.github.excel.easyexcel.listener.ExcelListener;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName EasyExcelUtil
 * @Description TODO
 * @Author Forlevin
 * @Date 2019/9/10 17:27
 * @Version 1.0
 **/
public class EasyExcelUtil {

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param inputStream    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(InputStream inputStream, BaseRowModel rowModel) throws IOException {
        return readExcel(inputStream, rowModel, 1, 1);
    }

    /**
     * 读取某个 sheet 的 Excel
     * @param inputStream       文件
     * @param rowModel    实体类映射，继承 BaseRowModel 类
     * @param sheetNo     sheet 的序号 从1开始
     * @param headLineNum 表头行数，默认为1
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(InputStream inputStream, BaseRowModel rowModel, int sheetNo, int headLineNum) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(inputStream, excelListener);
        if (reader == null) {
            return null;
        }
        reader.read(new Sheet(sheetNo, headLineNum, rowModel.getClass()));
        return excelListener.getList();
    }

    /**
     * 读取指定sheetName的Excel(多个 sheet)
     * @param inputStream    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @return Excel 数据 list
     * @throws IOException
     */
    public static List<Object> readExcel(InputStream inputStream, BaseRowModel rowModel,String sheetName) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(inputStream, excelListener);
        if (reader == null) {
            return null;
        }
        for (Sheet sheet : reader.getSheets()) {
            if (rowModel != null) {
                sheet.setClazz(rowModel.getClass());
            }
            //读取指定名称的sheet
            if(sheet.getSheetName().contains(sheetName)){
                reader.read(sheet);
                break;
            }
        }
        return excelListener.getList();
    }

    /**
     * 返回 ExcelReader
     * @param inputStream 需要解析的 Excel 文件
     * @param excelListener new ExcelListener()
     * @throws IOException
     */
    private static ExcelReader getReader(InputStream inputStream, ExcelListener excelListener) throws IOException {
            InputStream is = new BufferedInputStream(inputStream);
            return new ExcelReader(is, null, excelListener, false);
    }

}
