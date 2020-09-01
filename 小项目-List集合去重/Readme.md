题注：被面试官问到ArrayList如何去重，瞬间惊了，![img](assets/011D1BF52022734FFE6950250EEBDAC4.jpg)，这玩意儿不是有序可重复的吗，我HashSet它不香吗！你要在list里面去重，反正是一个都没答上，无奈百度之，其法众也！！！

下面看看List去重的几种方法！![img](assets/9AD47F7EEDAADB8C753646561A661144.jpg)

# List集合去重的几种方式

## 1、双重for循环

方式：通过两层循环来进行判断，没有重复的元素就加入到新集合中，新集合中已经有的元素就跳过。

- bean类

  ```java
  package com.pangchun.pojo;
  
  public class PersonBean {
      private String name;
      private Integer money;
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public Integer getMoney() {
          return money;
      }
  
      public void setMoney(Integer money) {
          this.money = money;
      }
  
      public PersonBean(String name, Integer money) {
          this.name = name;
          this.money = money;
      }
  
      @Override
      public String toString() {
          return "PersonBean{" +
                  "name='" + name + '\'' +
                  ", money=" + money +
                  '}';
      }
  }
  
  ```

- 测试类

  ```java
  package com.pangchun.test;
  import com.pangchun.pojo.PersonBean;
  import org.junit.Test;
  import java.util.ArrayList;
  import java.util.List;
  
  public class Test01 {
      /* 双重for循环去重 */
      @Test
      public void test1() {
          List<PersonBean> personBeanList = new ArrayList<PersonBean>();
          personBeanList.add(new PersonBean("p0",100));
          personBeanList.add(new PersonBean("p0",100));
          personBeanList.add(new PersonBean("p1",1000));
          personBeanList.add(new PersonBean("p1",1000));
  
          List<PersonBean> newPersonBeanList = new ArrayList<PersonBean>();
  
          for (PersonBean p:personBeanList) {
              if (newPersonBeanList.isEmpty()) {
                  newPersonBeanList.add(p);
              }else {
                  boolean isSame = false;
                  for (PersonBean p1:newPersonBeanList) {
                      /* 依靠name和money来判断有无重复元素，有就跳过 */
                      if (p1.getName().equals(p.getName()) && p1.getMoney().equals(p.getMoney())) {
                          isSame = true;
                          break;
                      }
                  }
                  if (!isSame) {
                      newPersonBeanList.add(p);
                  }
              }
          }
  
          System.out.println("========输出新的List============");
          for (PersonBean p:newPersonBeanList) {
              System.out.println(p.toString());
          }
      }
  }
  
  ```

- 测试结果

  ```java
  ========输出新的List============
  PersonBean{name='p0', money=100}
  PersonBean{name='p1', money=1000}
  ```

## 2、利用list中contains方法

方式：在使用`contains()`之前，必须要对`PenBean`类重写`equals()`方法。

- bean类

  ```java
  package com.pangchun.pojo;
  
  import java.util.Objects;
  
  public class PersonBean {
      private String name;
      private Integer money;
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public Integer getMoney() {
          return money;
      }
  
      public void setMoney(Integer money) {
          this.money = money;
      }
  
      public PersonBean(String name, Integer money) {
          this.name = name;
          this.money = money;
      }
  
      @Override
      public String toString() {
          return "PersonBean{" +
                  "name='" + name + '\'' +
                  ", money=" + money +
                  '}';
      }
  
      /* 重写equals方法 */
      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          PersonBean that = (PersonBean) o;
          /* 当name和money都相同时返回true */
          return Objects.equals(name, that.name) &&
                  Objects.equals(money, that.money);
      }
  
  }
  
  ```

- 测试类

  ```java
  package com.pangchun.test;
  
  import com.pangchun.pojo.PersonBean;
  import org.junit.Test;
  
  import java.util.ArrayList;
  import java.util.List;
  
  public class Test02 {
      
      @Test
      public void test1() {
          List<PersonBean> personBeanList = new ArrayList<PersonBean>();
          personBeanList.add(new PersonBean("p0",100));
          personBeanList.add(new PersonBean("p0",100));
          personBeanList.add(new PersonBean("p1",1000));
          personBeanList.add(new PersonBean("p1",1000));
          personBeanList.add(new PersonBean("p2",10000));
  
          List<PersonBean> newPersonBeanList = new ArrayList<PersonBean>();
  
          /* 使用contain判断，是否有相同的元素 */
          for (PersonBean p:personBeanList) {
              if (!newPersonBeanList.contains(p)) {
                  newPersonBeanList.add(p);
              }
          }
  
          System.out.println("========输出新的List============");
          for (PersonBean p:newPersonBeanList) {
              System.out.println(p.toString());
          }
      }
  }
  
  ```

- 测试结果

  ```java
  ========输出新的List============
  PersonBean{name='p0', money=100}
  PersonBean{name='p1', money=1000}
  PersonBean{name='p2', money=10000}
  ```

> 思考：为什么要重写`equals()`方法？
>
> - 打开`ArrayList`中`contains()`方法，源码如下：
>
> ```java
>  public boolean contains(Object o) {
>         return indexOf(o) >= 0;
>     }
> 
>     public int indexOf(Object o) {
>         if (o == null) {
>             for (int i = 0; i < size; i++)
>                 if (elementData[i]==null)
>                     return i;
>         } else {
>             for (int i = 0; i < size; i++)
>                 if (o.equals(elementData[i]))
>                     return i;
>         }
>         return -1;
>     }
> 
> ```
>
> 此时，非常清晰了，如果传入的对象是`null`，for循环判断数组中的元素是否有`null`，如果有就返回下标；如果传入的对象不是`null`，通过对象的`equals()`方法，for循环判断是否有相同的元素，如果有就返回下标！
>
> **如果是数组返回的下标，肯定是大于0，否则返回-1！**
>
> 这就是为什么在`List`中使用`contains()`方法，对象需要重写`equals()`方法的原因！

## 3、转换为HashSet去重

方式：`HashSet`集合天然支持元素不重复！bean类要同时重写`Object`中的`equals()`和`hashCode()`方法。

- bean类

  ```java
  package com.pangchun.pojo;
  
  import java.util.Objects;
  
  public class PersonBean {
      private String name;
      private Integer money;
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public Integer getMoney() {
          return money;
      }
  
      public void setMoney(Integer money) {
          this.money = money;
      }
  
      public PersonBean(String name, Integer money) {
          this.name = name;
          this.money = money;
      }
  
      @Override
      public String toString() {
          return "PersonBean{" +
                  "name='" + name + '\'' +
                  ", money=" + money +
                  '}';
      }
  
      /* 重写equals方法 */
      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          PersonBean that = (PersonBean) o;
          /* 当name和money都相同时返回true */
          return Objects.equals(name, that.name) &&
                  Objects.equals(money, that.money);
      }
  
      /* 重写hashcode方法 */
  
      @Override
      public int hashCode() {
          return Objects.hash(name, money);
      }
  }
  
  ```

- 测试类

  ```java
  package com.pangchun.test;
  
  import com.pangchun.pojo.PersonBean;
  import org.junit.Test;
  
  import java.util.ArrayList;
  import java.util.HashSet;
  import java.util.List;
  
  public class Test03 {
  
      @Test
      public void test1() {
          List<PersonBean> personBeanList = new ArrayList<PersonBean>();
          personBeanList.add(new PersonBean("p0",100));
          personBeanList.add(new PersonBean("p0",100));
          personBeanList.add(new PersonBean("p1",1000));
          personBeanList.add(new PersonBean("p1",1000));
          personBeanList.add(new PersonBean("p2",10000));
  
          List<PersonBean> newPersonBeanList = new ArrayList<PersonBean>();
  
          /* set去重 */
          HashSet<PersonBean> set = new HashSet<>(personBeanList);
          newPersonBeanList.addAll(set);
  
          System.out.println("========输出新的List============");
          for (PersonBean p:newPersonBeanList) {
              System.out.println(p.toString());
          }
      }
  }
  
  ```

- 测试结果

  ```java
  ========输出新的List============
  PersonBean{name='p0', money=100}
  PersonBean{name='p1', money=1000}
  PersonBean{name='p2', money=10000}
  ```

## 4、使用java8新特性stream进行List去重 

```java
package com.pangchun.test;

import com.pangchun.pojo.PersonBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Test04 {

    @Test
    public void test1() {
        List<PersonBean> personBeanList = new ArrayList<PersonBean>();
        personBeanList.add(new PersonBean("p0",100));
        personBeanList.add(new PersonBean("p0",100));
        personBeanList.add(new PersonBean("p1",1000));
        personBeanList.add(new PersonBean("p1",1000));
        personBeanList.add(new PersonBean("p2",10000));
        personBeanList.add(new PersonBean("p3",100000));

        List<PersonBean> newPersonBeanList = personBeanList.stream().distinct().collect(Collectors.toList());


        System.out.println("========输出新的List============");
        for (PersonBean p:newPersonBeanList) {
            System.out.println(p.toString());
        }
    }
}

```

> 利用 jdk1.8 中提供的`Stream.distinct()`列表去重，`Stream.distinct()`使用`hashCode()`和`equals()`方法来获取不同的元素，**因此使用这种写法，对象需要重写hashCode()和equals()方法！**

## 5、还可以利用Lambda表达式去重

自行百度吧......












































































































































































































































































































































































































