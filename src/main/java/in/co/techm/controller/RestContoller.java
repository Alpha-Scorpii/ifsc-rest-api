package in.co.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.co.techm.model.Bank;
import in.co.techm.model.GenericResponse;
import in.co.techm.repository.BankRepository;
import in.co.techm.service.BankService;

@RestController
public class RestContoller {

	@Autowired
	BankService mBankService;

	@RequestMapping(value = "/getbank/{bankName}/{branchName}", method = RequestMethod.GET)
	@ResponseBody
	ResponseEntity<GenericResponse<Bank>> getBank(@PathVariable(value = "bankName") String bankName,
			@PathVariable(value = "branchName") String branchName) {
		return mBankService.findByBranchAndBank(bankName, branchName);
	}

}
