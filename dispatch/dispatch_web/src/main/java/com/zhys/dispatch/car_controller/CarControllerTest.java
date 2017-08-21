package com.zhys.dispatch.car_controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhys.dispatch.dispatch_common.constant.ERRORCODE;
import com.zhys.dispatch.dispatch_common.constant.RESULTFLAGS;

@Controller
@RequestMapping(value = "/car")
public class CarControllerTest {

	private final Logger logger = LoggerFactory.getLogger(CarControllerTest.class);

	@RequestMapping(value = "/getCarInfoJson", method = RequestMethod.GET)
	public @ResponseBody Object getCarInfoJson(Model model, ServletRequest request,
			@RequestParam(value = "carNo", required = false) String carNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String fatypeTreeJson = "123";
			result.put("data", fatypeTreeJson);
			result.put("flag", RESULTFLAGS.SUCCESS.toString());
		} catch (Exception e) {
			logger.error(ERRORCODE.ERR_DB_001 + ":"
					+ ERRORCODE.getMsg(ERRORCODE.ERR_DB_001));
			result.put("flag", RESULTFLAGS.ERROR.toString());
		}
		return result;
	}
}
