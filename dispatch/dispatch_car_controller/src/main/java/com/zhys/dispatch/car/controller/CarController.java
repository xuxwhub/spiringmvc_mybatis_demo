package com.zhys.dispatch.car.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhys.dispatch.car.api.CarService;
import com.zhys.dispatch.dispatch_common.constant.ERRORCODE;
import com.zhys.dispatch.dispatch_common.constant.RESULTFLAGS;

@Controller
@RequestMapping(value = "/carInfo")
public class CarController implements ApplicationListener{

	private final Logger logger = LoggerFactory.getLogger(CarController.class);

//	@Autowired
//	private LocalMessageSource localMessageSource;
	@Autowired
	private CarService carService;

	@RequestMapping(value = "/getCarInfoJson", method = RequestMethod.GET)
	public @ResponseBody Object getCarInfoJson(Model model, ServletRequest request,
			@RequestParam(value = "carNo", required = false) String carNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String fatypeTreeJson = carService.getCarJson(carNo);
			result.put("data", fatypeTreeJson);
			result.put("flag", RESULTFLAGS.SUCCESS.toString());
		} catch (Exception e) {
			e.printStackTrace();
			// sql执行错误
			logger.error(ERRORCODE.ERR_DB_001 + ":"
					+ ERRORCODE.getMsg(ERRORCODE.ERR_DB_001));
			result.put("flag", RESULTFLAGS.ERROR.toString());
//			result.put("msg", localMessageSource.getMessage("10009"));
		}
		return result;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		System.out.println("test");
	}
}
