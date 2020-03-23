package net.arysu.wemakeprice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class OperationAction {
	
	private OperationService service;
	
	public OperationAction(OperationService service) {
		this.service = service;
	}

	@PostMapping("/operation")
	public Result<StringBundle> operation(@Valid @RequestBody OperationTO operationTO) {
		
		StringBundle bundle = service.operateCharacter(operationTO.getUrl(), operationTO.getExcludeTag(), operationTO.getBundleCount());
		return new Result<>(true, bundle);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	protected ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(new Result<>(false, ex.getMessage()), status);
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
	
	public static class Result<T> {
		
		private boolean success;
		private T data;
		
		public Result(boolean success, T data) {
			this.success = success;
			this.data = data;
		}

		public boolean isSuccess() {
			return success;
		}

		public T getData() {
			return data;
		}
	}

}
