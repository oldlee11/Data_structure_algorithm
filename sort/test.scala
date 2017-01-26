package sort
/**
  * Created by liming on 2017/1/24.
  */
object test {
  val data1:Array[Int]=Array(10)
  val data2:Array[Int]=Array(10,10)
  val data3:Array[Int]=Array(10,0,10)
  val data4:Array[Int]=Array(10,1,0,-1,3,201,9,9,20,1,10,30)
  def main_deal(fun_sort:(Array[Int]=>Array[Int])){
    val result1=fun_sort(data1)
    if(result1.length==1 & result1(0)==10){
      print("test1 ok\n")
    }else{
      print("test1 error\n")
    }
    val result2=fun_sort(data2)
    if(result2.length==2 & result2(0)==10 & result2(1)==10){
      print("test2 ok\n")
    }else{
      print("test2 error\n")
    }
    val result3=fun_sort(data3)
    if(result3.length==3 & result3(0)==0 & result3(1)==10 & result3(2)==10){
      print("test3 ok\n")
    }else{
      print("test3 error\n")
      result3.foreach(x=>print(x+"\t"))
      print("\n")
    }
    val result4=fun_sort(data4)
    if(result4.length==12 &
      result4(0)== -1 &
      result4(1)== 0 &
      result4(2)== 1 &
      result4(3)== 1 &
      result4(4)== 3 &
      result4(5)== 9 &
      result4(6)== 9 &
      result4(7)== 10 &
      result4(8)== 10 &
      result4(9)== 20 &
      result4(10)==30 &
      result4(11)== 201
    ){
      print("test4 ok\n")
    }else{
      print("test4 error\n")
      result4.foreach(x=>print(x+"\t"))
      print("\n")
    }
  }
  def main_deal2(fun_sort:((Array[Int],Int,Int)=>Unit)){
    fun_sort(data1,-1,-1)
    if(data1.length==1 & data1(0)==10){
      print("test1 ok\n")
    }else{
      print("test1 error\n")
    }
    fun_sort(data2,-1,-1)
    if(data2.length==2 & data2(0)==10 & data2(1)==10){
      print("test2 ok\n")
    }else{
      print("test2 error\n")
    }
    fun_sort(data3,-1,-1)
    if(data3.length==3 & data3(0)==0 & data3(1)==10 & data3(2)==10){
      print("test3 ok\n")
    }else{
      print("test3 error\n")
      data3.foreach(x=>print(x+"\t"))
      print("\n")
    }
    fun_sort(data4,-1,-1)
    if(data4.length==12 &
      data4(0)== -1 &
      data4(1)== 0 &
      data4(2)== 1 &
      data4(3)== 1 &
      data4(4)== 3 &
      data4(5)== 9 &
      data4(6)== 9 &
      data4(7)== 10 &
      data4(8)== 10 &
      data4(9)== 20 &
      data4(10)==30 &
      data4(11)== 201
    ){
      print("test4 ok\n")
    }else{
      print("test4 error\n")
      data4.foreach(x=>print(x+"\t"))
      print("\n")
    }
  }
}
