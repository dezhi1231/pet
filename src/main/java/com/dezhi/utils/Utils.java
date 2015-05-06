package com.dezhi.utils;

import org.springframework.web.multipart.MultipartFile;

public class Utils {

	public final static String UPLOAD_IMG_URL = "http://localhost:8080/demo/upload/";

	public static boolean checkIsImageFile(MultipartFile imageFile) {

		if (imageFile.getContentType().equals("image/jpeg")) {
			return true;
		}

		return false;

	}

}
