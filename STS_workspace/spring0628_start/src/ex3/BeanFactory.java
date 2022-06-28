package ex3;
// ObjectFactory 디자인 패턴을 사용해서 책임 분리
public class BeanFactory {
   
   public TV getBean(String beanName){
      TV tv = null;
      if(beanName.equals("samsung")) {
         tv = new SamsungTV();
      }else if(beanName.equals("lg")) {
         tv = new LgTV();
      }
      return tv;
   }
}