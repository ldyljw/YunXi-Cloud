package com.yunxi.framework.xss.core.clean;

/**
 * <p>
 * 对 HTML 文本中的有 Xss 风险的数据进行清理
 * </p>
 *
 * @author lidy
 * @since 2024-05-05
 */
public interface XssCleaner {

    /**
     * 清理有 Xss 风险的文本
     *
     * @param html 原 html
     * @return 清理后的 html
     */
    String clean(String html);

}
