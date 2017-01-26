package sort

/**
  * Created by liming on 2017/1/24.
  * 归并排序(Merge Sort)
  */
object Merge_Sort {
  //把swap_datai中的index1元素和index2元素互换
  def swap_datai(datas_in:Array[Int],index1:Int,index2:Int): Unit ={
    val swap_data=datas_in(index1)
    datas_in(index1)=datas_in(index2)
    datas_in(index2)=swap_data
  }

  // 合并两个已排好序的数组datas_in[left...middle]和datas_in[middle+1...right]
  /*
  * var dtest=Array(1,20,30,0,11,12,19,37)
    merge(dtest,0,2,7)
    dtest.foreach(x=>print(x+"\t"))
   >> 0	1	11	12	19	20	30	37
  * */
  def merge(datas_in:Array[Int],
             left_index:Int,
             middle_index:Int,
             right_index:Int): Unit ={
    val nums=right_index-left_index+1        //datas_in[left...right]的长度
    val nums_left=middle_index-left_index+1  //datas_in[left...middle]的长度
    val copy_datasin_left=for (i<-0 until nums_left) yield datas_in(left_index+i)//拷贝datas_in[left...middle]
    val nums_right=nums-nums_left          //datas_in[middle+1...right]的长度
    val copy_datasin_right=for(i<-0 until nums_right) yield datas_in(middle_index+1+i)//拷贝datas_in[middle+1...right]
    var left_index_tmp:Int=0  //datas_in[left...middle]的相对平移指针
    var right_index_tmp:Int=0 //datas_in[middle+1...right]的相对平移指针
    for(index_tmp<-0 until nums){//datas_in[left...right]的相对平移指针
      if(left_index_tmp==nums_left){
        //left已经遍历完了,则一定为right
        datas_in(index_tmp+left_index)=copy_datasin_right(right_index_tmp)
        right_index_tmp+=1
      }else if(right_index_tmp==nums_right){
        //right已经遍历完了,则一定为left
        datas_in(index_tmp+left_index)=copy_datasin_left(left_index_tmp)
        left_index_tmp+=1
      } else if(copy_datasin_left(left_index_tmp) < copy_datasin_right(right_index_tmp)){
        //如果left<right,则放置left
        datas_in(index_tmp+left_index)=copy_datasin_left(left_index_tmp)
        left_index_tmp+=1
      } else{
        //如果left>=right,则放置right
        datas_in(index_tmp+left_index)=copy_datasin_right(right_index_tmp)
        right_index_tmp+=1
      }
    }
  }

  //递归形式实现
  def main_deal_recursion(datas_in:Array[Int],
                left_index_org:Int= -1,
                right_index_org:Int= -1): Unit ={
    val nums=datas_in.length
    val left_index=if(left_index_org== -1) 0 else left_index_org
    val right_index=if(right_index_org== -1) nums-1 else right_index_org
    val middle_index:Int = (left_index + right_index)/2;
    if (left_index < right_index){// 当待排序的序列长度为1时(left == right),递归“开始回升”
      //先递归,后操作
      main_deal_recursion(datas_in, left_index, middle_index);
      main_deal_recursion(datas_in, middle_index + 1, right_index);
      merge(datas_in, left_index, middle_index, right_index);
    }
  }

  //非递归形式实现
  def main_deal_iteration(datas_in:Array[Int]): Array[Int] ={
    val nums:Int=datas_in.length
    var size:Int=1;//size表示merge时两边数据的长度,每次*2
    while(size<nums){
      var left_index:Int=0;
      var middle_index:Int=0;
      var right_index:Int= 1;
      while(middle_index<=(nums-1)){
        merge(datas_in,left_index,middle_index,right_index)
        left_index=left_index+2*size
        middle_index=left_index+size-1
        right_index=left_index+2*size-1
        if(right_index>=nums-1)
          right_index=nums-1
      }
      size *= 2
    }
    datas_in
  }

  //test
  def main(args: Array[String]): Unit = {
    var dtest=Array(1,20,30,0,11,12,19,37)
    merge(dtest,0,2,7)
    dtest.foreach(x=>print(x+"\t"))
    print("\n")
    test.main_deal2(main_deal_recursion)
    print("\n")
    test.main_deal(main_deal_iteration)
  }
}
