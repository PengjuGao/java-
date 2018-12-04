/**
 * @author gaopj
 *
 */
package com.platform.core.service;

import com.platform.core.param.FeedbackParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.po.TbFeedback;
import com.platform.core.vo.TbFeedbackVo;
import com.platform.base.service.BaseService;

public interface TbFeedbackService extends BaseService<TbFeedback, TbFeedbackVo>{

    /**
     * 新增反馈信息
     * @param param
     * @return
     */
    CommonResult addFeedback(FeedbackParam param);

    /**
     * 根据用户id 查询对应的反馈信息
     * @param userId
     * @return
     */
    CommonResult listFeedback(long userId);
}
