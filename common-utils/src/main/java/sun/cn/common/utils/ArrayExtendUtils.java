package sun.cn.common.utils;


import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

/**
 * 列表扩展工具类
 *
 * @author sunlingao@58.com
 * @date 2016年3月7日
 */
public final class ArrayExtendUtils extends ArrayUtils{

    private static Logger logger = Logger.getLogger(ArrayExtendUtils.class);

    /**
     * 根据主键查找列表中对应对象
     *
     * @param list        列表
     * @param equalsValue 匹配值
     * @return 对象所在下标 (大于-1找到下标)
     * @throws Exception
     */
    public static <T> T findObjectByList(final List<T> list, final String equalsValue) {
        return findObjectByList(list, equalsValue, "id");
    }

    /**
     * 根据主键查找列表中对应对象
     *
     * @param list        列表
     * @param equalsValue 匹配值
     * @param indexStr    主键字段
     * @return
     * @throws Exception
     */
    public static <T> T findObjectByList(final List<T> list, final String equalsValue, final String indexStr) {
        int index = -1;
        int i = -1;
        if (list != null && list.size() > 0) {
            for (T t : list) {
                i++;
                try {
                    Field field = t.getClass().getDeclaredField(indexStr);
                    field.setAccessible(true);
                    Object value = field.get(t);
                    if (value != null) {
                        if (value.equals(equalsValue)) {
                            index = i;
                            break;
                        }
                    }
                } catch (Exception e) {
                    logger.error("findObjectByList", e);
                }
            }
        }
        return index > -1 ? list.get(index):null;
    }
    
    /**
     * <p>根据arg属性降序排序<br>
     * 如果arg属性实现了Comparable接口,就调用compareTo方法比较<br>
     * 否则用hashCode方法比较</p>
     * @author:sunlingao@58.com
     * @date:2016年8月10日
     * @param list 列表
     * @param arg 排序字段
     * @return
     * List<T>
     */
    public static <T> List<T> sortByList(List<T> list,String arg){
        boolean isComparable = false;
        if(CollectionUtils.isEmpty(list)) return null;
        Object obj = list.get(0);
        try{
        Field field = obj.getClass().getDeclaredField(arg);
        if(field == null ) {
            logger.warn(String.format("sortByList arg is miss", arg));
            return null;
        }
        field.setAccessible(true);
        if(Comparable.class.isAssignableFrom(field.getType())){
            isComparable = true;
        }
        return isComparable?sortByComparableList(list,arg):sortByHashCodeList(list,arg);
        }catch(Exception e){
            logger.error("sortByList", e);
        }
        return null;
    }
    
    /**
     * 根据compareTo排序
     * @author:sunlingao@58.com
     * @date:2016年8月10日
     * @param list
     * @param arg
     * @return
     * List<T>
     */
    private static <T> List<T> sortByComparableList(List<T> list,final String arg) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 != null && o2 != null) {
                    try {
                        Field field = o1.getClass().getDeclaredField(arg);
                        field.setAccessible(true);
                        Object obj1 = field.get(o1);
                        Object obj2 = field.get(o2);
                        if(obj1 !=null && obj2!= null){
                            Comparable<Object> compare1 = (Comparable)obj1;
                            Comparable<Object> compare2 = (Comparable)obj2;
                            return compare2.compareTo(compare1);
                        }
                    } catch (Exception e) {
                        logger.error("sortByComparableList", e);
                    }
                }
                return 0;
            }
        });
        return list;
    }
    
    /**
     * 根据hashcode排序
     * @author:sunlingao@58.com
     * @date:2016年8月10日
     * @param list
     * @param arg
     * @return
     * List<T>
     */
    private static <T> List<T> sortByHashCodeList(List<T> list,final String arg) {
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 != null && o2 != null) {
                    return o2.hashCode() > o1.hashCode() ? 1: 0;
                }
                return 0;
            }
        });
        return list;
    }

}
