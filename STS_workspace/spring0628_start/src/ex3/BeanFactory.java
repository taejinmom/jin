package ex3;
// ObjectFactory ������ ������ ����ؼ� å�� �и�
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