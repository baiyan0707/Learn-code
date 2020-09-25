package blog.baiyan.github.excel.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * @ClassName ExcelListener
 * @Description TODO
 * @Author Forlevin
 * @Date 2019/9/10 17:23
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class ExcelListener extends AnalysisEventListener {

    private ArrayList list = new ArrayList();

    @Override
    public void invoke(Object object, AnalysisContext analysisContext) {
        list.add(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
