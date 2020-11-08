package cn.aprilviolet.fundamentals.datastructure;

import cn.aprilviolet.fundamentals.datastructure.tree.Trie;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 字典树的测试类
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.17 星期六 23:10
 * @since V1.0.0
 */
@Log4j2
class TrieTest {
    @Test
    @DisplayName(value = "字典树测试")
    void trieTest() {
        Trie trie = new Trie();
        trie.add("April");
        trie.add("Violet");
        trie.add("Test");
        trie.add("Apple");

        log.info("存在与否:{}", trie.contains("April"));
        log.info("存在与否:{}", trie.isPrefix("aApril"));
        log.info("存在与否:{}", trie.isPrefix("Ap"));
    }
}
