package sort

/**
  * Created by liming on 2017/1/24.
  * 选择排序也是一种简单直观的排序算法
  * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置search_bottom_index
  * 以此类推，直到所有元素均排序完毕
  * 性能
分类 -------------- 内部比较排序
数据结构 ---------- 数组
最差时间复杂度 ---- O(n^2)
最优时间复杂度 ---- O(n^2)
平均时间复杂度 ---- O(n^2)
所需辅助空间 ------ O(1)
稳定性 ------------ 不稳定
  **/
object Selection_Sort {
  //把swap_datai中的index1元素和index2元素互换
  def swap_datai(datas_in:Array[Int],index1:Int,index2:Int): Unit ={
    val swap_data=datas_in(index1)
    datas_in(index1)=datas_in(index2)
    datas_in(index2)=swap_data
  }

  //在datas_in[search_bottom_index,...,search_top_index]内选择
  //最小值的地址
  def find_mindata_index(datas_in:Array[Int],search_bottom_index:Int,search_top_index:Int):Int={
    var mindata_index=search_bottom_index//最小值的指针默认等于底部指针search_bottom_index
    for(search_index <- search_bottom_index to search_top_index){
      if(datas_in(search_index)<datas_in(mindata_index)){
        mindata_index=search_index//更新最小值的指针
      }
    }
    mindata_index
  }

  def main_deal(datas_in:Array[Int]):Array[Int]={
    val nums:Int=datas_in.length
    val search_top_index:Int=nums-1//顶部index指针永远 等于最后一个index
    for(search_bottom_index <- 0 until nums-1){//底部指针=[0,nums-2]
      //完成一次选择排序,使最小值数据和底部指针search_bottom_index处数据,相互互换
      val mindata_index:Int=find_mindata_index(datas_in,search_bottom_index,search_top_index)
      //对最小值的指针数据和底部指针的数据做交换
      swap_datai(datas_in,mindata_index,search_bottom_index)
    }
    datas_in
  }

  //test
  def main(args: Array[String]): Unit = {
    test.main_deal(main_deal)
  }

}
