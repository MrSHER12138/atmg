package com.sher.atmg.controller;

import com.sher.atmg.config.CommonConfig;
import com.sher.atmg.utils.MultipartFileSender;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件处理
 *
 * @author ·SHER·
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/file" )
@CrossOrigin(origins = "*")
public class FileController {

	@Autowired
	private CommonConfig commonConfig;

//	@GetMapping("/videos/{videoName}")
//	public ResponseEntity<byte[]> getVideo(@PathVariable String videoName) throws IOException {
//		Path videoPath = Paths.get(commonConfig.getVideoDirectory()).resolve(videoName);
//		Resource videoResource = new UrlResource(videoPath.toUri());
//		if (videoResource.exists() && videoResource.isReadable()) {
//			byte[] videoData = Files.readAllBytes(videoPath);
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//			headers.setContentDispositionFormData("attachment", videoName);
//			return ResponseEntity.ok()
//					.headers(headers)
//					.body(videoData);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}。

	@GetMapping("/images/{imageName}")
	public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
		Path imagePath = Paths.get(commonConfig.getImageDirectory()).resolve(imageName);
		Resource imageResource = new UrlResource(imagePath.toUri());
		if (imageResource.exists() && imageResource.isReadable()) {
			byte[] imageData = Files.readAllBytes(imagePath);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG); // 根据实际图片类型设置对应的 MediaType
			return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	@GetMapping("/videos/{videoName}")
//	public ResponseEntity<byte[]> getVideoRange(@PathVariable String videoName,
//												@RequestHeader(value = "Range", required = false) String rangeHeader) throws IOException {
//		Path videoPath = Paths.get(commonConfig.getVideoDirectory()).resolve(videoName);
//		Resource videoResource = new UrlResource(videoPath.toUri());
//
//		if (videoResource.exists() && videoResource.isReadable()) {
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//			long videoSize = videoResource.contentLength();
//			headers.setContentLength(videoSize);
//
//			if (rangeHeader != null && rangeHeader.startsWith("bytes=")) {
//				String[] range = rangeHeader.substring(6).split("-");
//
//				long chunkSize = 1000000;
//
//				long start = Long.parseLong(range[0]);
//				//判断结束字节
//				//Safari/iOS发送的是0-1
//
//				long endLength = 0;
//                if (range.length != 1) {
//                    endLength = Long.parseLong(range[1]);
//                }
//
//                long end = endLength == 0 ? Math.min(start + chunkSize, videoSize) - 1 : endLength;
//				long contentLength = end - start + 1;
//
//				headers.set("Content-Range", "bytes " + start + "-" + end + "/" + videoSize);
//				headers.set("Accept-Ranges", "bytes");
//				headers.setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
//
//				try (InputStream inputStream = videoResource.getInputStream()) {
//					inputStream.skip(start);
//					byte[] videoData = inputStream.readNBytes((int) contentLength);
//					return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
//							.headers(headers)
//							.body(videoData);
//				}
//			} else {
//				byte[] videoData = Files.readAllBytes(videoPath);
//				headers.setContentDispositionFormData("attachment", videoName);
//				return ResponseEntity.ok()
//						.headers(headers)
//						.body(videoData);
//			}
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

	@GetMapping("/videos/{videoName}")
	public void getVideoRange(@PathVariable String videoName, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Path videoPath = Paths.get(commonConfig.getVideoDirectory()).resolve(videoName);
		MultipartFileSender.fromPath(videoPath)
				.with(request)
				.with(response)
				.serveResource();
	}
}