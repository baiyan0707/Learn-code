package blog.baiyan.github.excel.easyexcel.test;

import blog.baiyan.github.excel.easyexcel.entity.UserHealthInfo;
import blog.baiyan.github.excel.poiexcel.dto.UserHealthInfoDTO;
import blog.baiyan.github.excel.poiexcel.utils.ExcelUtil2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author 本地 Excel 导入
 * @version 1.0
 */
@Slf4j
public class ImportExcelTest {
    public static  void main(String[] args) throws Exception {
        String file = "";

        ExcelUtil2 excelUtil2 = new ExcelUtil2();
        List<UserHealthInfoDTO> list = excelUtil2.parseFromExcel(file, 1, UserHealthInfoDTO.class);

        assert list != null;
        //存储第一次过滤的数据（一个用户的全部体检信息信息）
        List<UserHealthInfoDTO> entityList = new ArrayList<>();
        //存储第二次过滤的数据（需要存入数据库的字段信息）
        List<UserHealthInfo> infoList = new ArrayList<>();
        List<String> idArr = new ArrayList<>();
        idArr.add("1341780");
        idArr.add("1409980");
        idArr.add("1497936");

        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);
        list.forEach(entity -> {
            for (String id : idArr) {
                if (Objects.equals(id, entity.getOrderNumber())) {
                    entity.setUserId(id);
                    entityList.add(entity);
                }
            }
            // System.out.println(helists);
            // 将一个用户的多条体检记录保存
            UserHealthInfo userHealthInfo = new UserHealthInfo();
            if (!CollectionUtils.isEmpty(entityList)) {
                entityList.forEach(en -> {
                    if (Objects.equals("身高", en.getExamProject())) {
                        if (!Objects.equals("自愿放弃", en.getResult())) {
                            userHealthInfo.setHeight(Double.parseDouble(en.getResult()));
                        }else {
                            userHealthInfo.setHeight(0.00);
                        }
                    }
                    if (Objects.equals("体重", en.getExamProject())) {
                        if (!Objects.equals("自愿放弃", en.getResult())) {
                            userHealthInfo.setWeight(Double.parseDouble(en.getResult()));
                        }else {
                            userHealthInfo.setWeight(0.00);
                        }
                    }
                    if (Objects.equals("收缩压", en.getExamProject())) {
                        if (!Objects.equals("自愿放弃", en.getResult())) {
                            userHealthInfo.setBloodPressure(en.getResult());
                        }
                    }
                    if (Objects.equals("甘油三酯（TG）", en.getExamProject())) {
                        if (!Objects.equals("自愿放弃", en.getResult())) {
                            userHealthInfo.setTG(Double.parseDouble(en.getResult()));
                        }else {
                            userHealthInfo.setTG(0.00);
                        }
                    }
                    if (Objects.equals("尿酸（UA）", en.getExamProject())) {
                        if (!Objects.equals("自愿放弃", en.getResult())) {
                            userHealthInfo.setUA(Double.parseDouble(en.getResult()));
                        }else {
                            userHealthInfo.setUA(0.00);
                        }
                    }if (Objects.equals("总胆固醇（TC）", en.getExamProject())) {
                        if (!Objects.equals("自愿放弃", en.getResult())) {
                            userHealthInfo.setTC(Double.parseDouble(en.getResult()));
                        }else {
                            userHealthInfo.setTC(0.00);
                        }
                    }
                    if (Objects.equals("低密度脂蛋白胆固醇（LDL-C）", en.getExamProject())) {
                        if (!Objects.equals("自愿放弃", en.getResult())) {
                            userHealthInfo.setLDL(Double.parseDouble(en.getResult()));
                        }else {
                            userHealthInfo.setLDL(0.00);
                        }
                    }
                    if (Objects.equals("高密度脂蛋白胆固醇（HDL-C）", en.getExamProject())) {
                        if (!Objects.equals("自愿放弃", en.getResult())) {
                            userHealthInfo.setHDL(Double.parseDouble(en.getResult()));
                        }else {
                            userHealthInfo.setHDL(0.00);
                        }
                    }
                    userHealthInfo.setUser(en.getUserId());
                    /*if (!IsNotEmptyBeanUtil.checkObjAllFieldsIsNull(userHealthInfo)) {
                        infoList.add(userHealthInfo);
                    }*/
                });
            }
        });
        long endTime = System.currentTimeMillis();
        System.out.println("结束时间：" + endTime);
        System.out.println("导入时长：" + (endTime - startTime));

        // 将多个对象赋值到一个对象中
        Map<String, Object> infoMap = new HashMap<>();
        Set set = new HashSet();
        for (UserHealthInfo info : infoList) {
            for (int i = 0; i < idArr.size(); i++) {
                UserHealthInfo userHealthInfo = new UserHealthInfo();

                if (!Objects.equals(null, info.getHeight())) {
                    userHealthInfo.setHeight(Double.parseDouble(info.getHeight().toString()));
                }
                if (!Objects.equals(null, info.getWeight())) {
                    userHealthInfo.setWeight(Double.parseDouble(info.getWeight().toString()));
                }
                if (!Objects.equals(null, info.getHDL())) {
                    userHealthInfo.setHDL(Double.parseDouble(info.getHDL().toString()));
                }
                if (!Objects.equals(null, info.getLDL())) {
                    userHealthInfo.setLDL(Double.parseDouble(info.getLDL().toString()));
                }
                if (!Objects.equals(null, info.getTC())) {
                    userHealthInfo.setTC(Double.parseDouble(info.getTC().toString()));
                }
                if (!Objects.equals(null, info.getTG())) {
                    userHealthInfo.setTG(Double.parseDouble(info.getTG().toString()));
                }
                if (!Objects.equals(null, info.getUA())) {
                    userHealthInfo.setUA(Double.parseDouble(info.getUA().toString()));
                }
                userHealthInfo.setUser(info.getUser());

                set.add(userHealthInfo);
                for (Object obj : set) {
                    if (obj instanceof UserHealthInfo) {
                        UserHealthInfo ui = (UserHealthInfo) obj;
                        infoMap.put(ui.getUser(),ui);
                    }
                }
            }
        }
        Set<Map.Entry<String, Object>> entries = infoMap.entrySet();
        for (Map.Entry<String, Object> key : entries) {
            UserHealthInfo uhi = (UserHealthInfo) key.getValue();
            System.out.println(uhi);
        }

        long finalTime = System.currentTimeMillis();
        System.out.println("花费的总时长：" + (finalTime - startTime));
    }
}
