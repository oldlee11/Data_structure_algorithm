package sort

/**
  * Created by liming on 2017/1/24.
  * 冒泡排序
  * 每次冒泡后,把越大的元素,经由交换慢慢“浮”到数列的顶端(尾部)。
  * 性能
// 分类 -------------- 内部比较排序
// 数据结构 ---------- 数组
// 最差时间复杂度 ---- O(n^2)
// 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
// 平均时间复杂度 ---- O(n^2)
// 所需辅助空间 ------ O(1)
// 稳定性 ------------ 稳定

  refer http://www.cnblogs.com/eniac12/p/5329396.html#s12
  */
object Bubble_Sort {
  //把swap_datai中的index1元素和index2元素互换
  def swap_datai(datas_in:Array[Int],index1:Int,index2:Int): Unit ={
    val swap_data=datas_in(index1)
    datas_in(index1)=datas_in(index2)
    datas_in(index2)=swap_data
  }

  //search_bottom_index,search_top_index 上浮和下沉的地址范围
  //is_upmax=true 表示把max值向top上浮 ,完成一次冒泡后,最大元素就像气泡一样"浮"到数组的最后(search_top_index)处
  //        =false 表示把min值向bottom下沉 ,完成一次冒泡后,最小元素就像气泡一样"沉"到数组的最开始(search_bottom_index)处
  def up_max_down_min(datas_in:Array[Int],search_bottom_index:Int,search_top_index:Int,is_upmax:Boolean=true): Unit ={
    val search_indexs=if(is_upmax) (search_bottom_index until search_top_index) else (search_bottom_index until search_top_index).reverse
    for(search_index <- search_indexs ){
      val search_index_next:Int=search_index+1//冒泡时候的指针的下一个指针
      if(datas_in(search_index)>datas_in(search_index_next)){
        //如果指针(search_index)的数据大于下一个指针(search_index_plus_one)的数据的数据
        //则交换它们指向的数据
        swap_datai(datas_in,search_index_next,search_index)
      }
    }
  }

  def main_deal(datas_in:Array[Int]):Array[Int]={
    val nums:Int=datas_in.length;
    for(search_top_index <- (1 until nums).reverse){//search_top_index 是单次冒泡的最大指针
      up_max_down_min(datas_in,0,search_top_index,true)
    }
    datas_in
  }

  //test
  def main(args: Array[String]): Unit = {
    test.main_deal(main_deal)
  }
}
