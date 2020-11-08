package cn.aprilviolet.fundamentals.datastructure;

import cn.aprilviolet.fundamentals.datastructure.tree.BinarySearchTree;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 * 二叉树的测试类
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.16 星期五 22:46
 * @since V1.0.0
 */
@Log4j2
class BinarySearchTreeTest {
    @Test
    void binarySearchTreeTest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {10, 5, 11, 7, 6, 8, 4, 13, 3};
        for (int num : nums) {
            bst.add(num);
        }
        //////////////////////
        //         10        //
        //       /   \       //
        //      5    11      //
        //     / \    \      //
        //    4  7     13   //
        //   /\  /\         //
        //  3   6  8        //
        ////////////////////
        log.info("==前序遍历==");
        bst.preOrder();
        log.info("==中序遍历==");
        bst.inOrder();
        log.info("==后续遍历==");
        bst.postOrder();
        log.info("==层序遍历==");
        bst.levelOrder();
        log.info("最小元素:{}", bst.minElement());
        log.info("最大元素:{}", bst.maxiElement());
        /*log.info("移除二叉树中最小的元素:{}", bst.removeMin());
        log.info("移除二叉树中最大的元素:{}", bst.removeMax());*/
        log.info("==层序遍历==");
        bst.levelOrder();

        bst.remove(5);
        log.info("==移除某元素后层序遍历==");
        bst.levelOrder();

        log.warn("=========");
        log.info(bst);
    }
}
