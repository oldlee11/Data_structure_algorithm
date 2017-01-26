package sort

import scala.util.control._

/**
  * Created by liming on 2017/1/24.
  * 插入排序(Insertion Sort)
  * 类似于玩扑克牌,对于未排序数据(右手抓到的牌)，在已排序序列(左手已经排好序的手牌)中从后向前扫描，找到相应位置并插入。
　** * * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
  *
  *性能
  * // 分类 ------------- 内部比较排序
  * // 数据结构 ---------- 数组
  * // 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
  * // 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
  * // 平均时间复杂度 ---- O(n^2)
  * // 所需辅助空间 ------ O(1)
  * // 稳定性 ------------ 稳定
  */
object Insertion_Sort {
  //把没有排好序的datas_in[search_top_index],
  //插入到已经排好序的datas_in[search_bottom_index,...,search_top_index-1]中
  def insert_data(datas_in:Array[Int],
                   search_bottom_index:Int,
                   search_top_index:Int): Unit ={
    var unsort_data=datas_in(search_top_index)
    val loop = new Breaks;
    loop.breakable {
      for (search_indexi <- (search_bottom_index to search_top_index-1).reverse) {//search_index反向遍历search_top_index-1--->search_bottom_index
        //向top平移
        datas_in(search_indexi + 1) = datas_in(search_indexi)
        if (datas_in(search_indexi) <= unsort_data) {
          //插入后并跳出循环
          datas_in(search_indexi + 1) = unsort_data
          loop.break;
        } else {
          //遍历后始终没有插入操作,则在循环结束后放于search_bottom_index处
          if(search_indexi==search_bottom_index){
            datas_in(search_bottom_index) = unsort_data
          }
        }
      }
    }
  }

  def main_deal(datas_in:Array[Int]):Array[Int]={
    val nums:Int=datas_in.length
    val search_bottom_index=0
    for (search_top_index <- 1 until nums) {
      insert_data(datas_in,search_bottom_index,search_top_index)
    }
    datas_in
  }

  //test
  def main(args: Array[String]): Unit = {
    test.main_deal(main_deal)
  }

}
