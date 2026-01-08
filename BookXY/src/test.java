public class test {
    public static boolean solution(String str, String ending) {
      for(String[] i:ending){
        System.out.println(i);
      }
        System.out.println(ending.charAt(i));
        String[] newstr=str.split(ending);
      System.out.println(newstr[-1]);
      if(newstr[-1]==ending){
       return true;
     }
     return false;
      }
     
  }
}
