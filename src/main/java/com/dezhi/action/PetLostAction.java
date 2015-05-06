package com.dezhi.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dezhi.entity.PetLostEntity;
import com.dezhi.entity.PetTypeEntity;
import com.dezhi.services.IPetLostService;
import com.dezhi.services.IPetTypeService;
import com.dezhi.utils.Utils;

@Controller
@RequestMapping(value = "/petlost/**")
public class PetLostAction {

	@Autowired
	private IPetLostService petLostService;
	@Autowired
	private IPetTypeService petTypeService;

	/**
	 * 查询宠物丢失记录
	 * 
	 * @param page
	 * @param location
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryPetLostInfo", method = RequestMethod.GET)
	public String queryPetLostInfo(int page, String location, Model model) {

		List<PetLostEntity> petList = petLostService.queryPetLostInfo(page,
				location);

		model.addAttribute("petList", petList);

		return "/lost/lost";
	}

	/**
	 * 下拉更多
	 * 
	 * @param page
	 * @param location
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryPetLostByPull", method = RequestMethod.GET)
	public @ResponseBody List<PetLostEntity> queryPetLostByPull(int page,
			String location) {

		List<PetLostEntity> petList = petLostService.queryPetLostInfo(page,
				location);

		return petList;
	}

	/**
	 * 初始化添加丢失信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toAddPetLostInfoPage", method = RequestMethod.GET)
	public String toAddPetLostInfoPage(Model model) {

		// 默认查询 狗类型
		List<PetTypeEntity> petTypeList = petTypeService
				.queryPetTypeByTypeId(1);

		model.addAttribute("petTypeList", petTypeList);

		return "/lost/addlostinfo";
	}

	@RequestMapping(value = "/addPetLostInfoPage", method = RequestMethod.POST)
	public String addPetLostInfoPage(PetLostEntity petLostEntity,
			MultipartFile imageFile, HttpServletRequest request,Model model) {

		String newfilename = "1.jpg";

		// 判断
		if (imageFile != null) {

			if (Utils.checkIsImageFile(imageFile)) {

				newfilename = UUID.randomUUID() + ".jpg";

				File targetFile = new File(request.getServletContext()
						.getRealPath("/upload"), newfilename);

				try {
					imageFile.transferTo(targetFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		if (petLostEntity != null) {

			petLostEntity.setImg_url(Utils.UPLOAD_IMG_URL + newfilename);

			petLostService.addPetLostInfo(petLostEntity);

		}
		
		List<PetLostEntity> petList = petLostService.queryPetLostInfo(0,null);

		model.addAttribute("petList", petList);

		return "lost/lost";
	}

	@RequestMapping(value = "/queryPetTypeList", method = RequestMethod.GET)
	public @ResponseBody List<PetTypeEntity> queryPetTypeList(int petType) {

		List<PetTypeEntity> petTypeList = petTypeService
				.queryPetTypeByTypeId(petType);

		return petTypeList;

	}

}
