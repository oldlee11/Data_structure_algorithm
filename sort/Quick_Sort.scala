package sort

/**
  * Created by liming on 2017/1/25.
  * 快速排序(Quicksort)
  *
  * 性能
 分类 ------------ 内部比较排序
 数据结构 --------- 数组
 最差时间复杂度 ---- 每次选取的基准都是最大的元素（或者每次都是最小），导致每次只划分出了一个子序列，需要进行n-1次划分才能结束递归，时间复杂度为O(n^2)
 最优时间复杂度 ---- 每次选取的基准都能使划分均匀，只需要logn次划分就能结束递归，时间复杂度为O(nlogn)
 平均时间复杂度 ---- O(nlogn)
 所需辅助空间 ------ O(logn)～O(n),主要是递归造成的栈空间的使用(用来保存left和right等局部变量),取决于递归树的深度
                   一般为O(logn),最差为O(n)（基本有序的情况）
 稳定性 ---------- 不稳定
  **/
object Quick_Sort {
  //把swap_datai中的index1元素和index2元素互换
  def swap_datai(datas_in:Array[Int],index1:Int,index2:Int): Unit ={
    val swap_data=datas_in(index1)
    datas_in(index1)=datas_in(index2)
    datas_in(index2)=swap_data
  }

  //以right地址的数据为基准pivot,把datas_in内的left-right元素按照pivot进行切分,并得到pivot的地址pivot_index
  //使小于pivot的元素在pivot_index以前，大于pivot的元素在pivot_index以后
  //而pivot正好排序到了pivot_index处
  def partition(datas_in:Array[Int],
                left_index:Int,
                right_index:Int):Int={
    val piovt_data=datas_in(right_index)//基准数据
    //tail_index为小于基准的子数组最后一个元素的索引,
    //把小于等于基准的元素放到前一个子数组中,
    //即如果datas_in(i)<=基准数据,则需要把datas_in(i)插入小于piovt的子数组内
    //等价于把datas_in(i)和datas_in(tail_index)互换
    var tail_index:Int = left_index
    for (i <- left_index until right_index){// 遍历基准以外的其他元素,由于piovt_data=datas_in(right_index),所以遍历 left_index until right_index
      if(datas_in(i) <= piovt_data) {
        swap_datai(datas_in,i,tail_index)
        tail_index += 1;
      }
    }
    // 最后把基准放到前一个子数组的后边,剩下的子数组既是大于基准的子数组
    // 该操作很有可能把后面元素的稳定性打乱,所以快速排序是不稳定的排序算法
    swap_datai(datas_in,tail_index,right_index)
    var pivot_index:Int=tail_index//基准的索引地址
    pivot_index
  }

  //递归操作,没有输出
  def main_deal(datas_in:Array[Int],
                left_index_org:Int= -1,
                right_index_org:Int= -1){
    val nums=datas_in.length
    val left_index=if(left_index_org== -1) 0 else left_index_org
    val right_index=if(right_index_org== -1) nums-1 else right_index_org
    if (left_index < right_index) {
      //先操作,在递归
      //left_index < right_index保证了left_index和 right_index没有相遇
      val pivot_index:Int = partition(datas_in, left_index, right_index);
      //注意此时的pivot_index已经在自己的位置,所以不用管了
      main_deal(datas_in, left_index, pivot_index-1);
      main_deal(datas_in, pivot_index+1, right_index);
    }
  }

  //test
  def main(args: Array[String]): Unit = {
    var dtest=Array(1,3,2,0,1,0,9,7,10)
    print(partition(dtest,0,8)+"\n")
    dtest.foreach(x=>print(x+"\t"))
    test.main_deal2(main_deal)
  }
}
