package com.seven.sevice;

import com.seven.dao.SortDao;
import com.seven.domain.Sort;

import java.util.List;

/**
 * @ClassName:SortService
 * @Description: 分类功能的业务层
 * 分类的控制层调用service功能
 * @Author:Admin
 * @Date: 2019/1/2615:38
 * @version: 1.0
 */
public class SortService {
    //创建dao层，SortDao类对象
    private SortDao sortDao = new SortDao();
    /**
     * 定义方法，调用dao层SortDao addSort添加分类
     * 传递Sort对象
     * service层方法中的Sort对象，是controller传递的
     */
    public void addSort(Sort sort){
        sortDao.addSort(sort);
    }
    /**
     * 定义方法，调用dao层SortDao#querySortAll获取所有分类数据
     * 返回的是List集合，存储Sort对象
     */

    public List<Sort> querySortAll(){
        return sortDao.querySortAll();
    }
}
