package pl.minicode.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.minicode.domain.DocumentPage;
import pl.minicode.service.IPageService;
import pl.minicode.utils.PaginationUtils;

@Controller
public class PageController {
	
	@Autowired
	private IPageService pageService;

	@GetMapping("/pagelist")
	public String showNewsListPageForm(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(PaginationUtils.DEFAULT_PAGE);
		int pageSize = size.orElse(PaginationUtils.PAGE_SIZE);

		Page<DocumentPage> pageList = pageService.findAll(PageRequest.of(currentPage - 1, pageSize));		
		model.addAttribute("pageList", pageList);

		int totalPages = pageList.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		return "page-list"; // view
	}

	@GetMapping("/createpage")
	public String createBookForm(DocumentPage page) {
		return "create-page";
	}

	@PostMapping("/savepage")
	public String saveBook(@Valid DocumentPage page, BindingResult result, Model model, @RequestParam("file") MultipartFile file) {
		if (result.hasErrors()) {
			return "create-page";
		}
		
//		if(doSaveFile) {
//			String generatedFileName = CustomUtils.getGeneratedFileName(file);
//			news.setImageName(generatedFileName);			
//			fileSystemStorageService.store(file, generatedFileName, ImageType.NEWS);			
//		}
//		newsRepository.save(news);
		return "redirect:/pagelist";
	}
}
