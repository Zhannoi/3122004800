package org.example.demo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testCalculatePlagiarismRate() {
        // 模拟输入的原始文本和抄袭文本
        String originalText = "This is the original text.";
        String plagiarizedText = "This is the plagiarized text.";

        // 调用被测试的方法
        double plagiarismRate = calculatePlagiarismRate(originalText, plagiarizedText);
        // 使用断言验证实际计算结果与预期结果是否一致
        assertEquals(40.0, plagiarismRate, 0.01); // 在这个示例中，我们期望两个文本的相似度为 0.5
    }

    private double calculatePlagiarismRate(String originalText, String copiedText) {
        //将文档分为小字符串
        String[] originalWords = originalText.split("[。,\\s\t\n]+");
        String[] copiedWords = copiedText.split("[。,\\s\t\n]+");

        int originalWordCount = originalWords.length;
        int commonWordCount = 0;

        for (int i = 0; i < originalWords.length; i++) {
            for (int j = 0; j < copiedWords.length; j++) {
                if (originalWords[i].length() >= 4 && copiedWords[j].length() >= 4) {
                    if (originalWords[i].substring(0, 4).equals(copiedWords[j].substring(0, 4))) {
                        commonWordCount++;
                        break;
                    }
                }
            }
        }
        return ((double) commonWordCount / originalWordCount) * 100;
    }
}

