package pl.minicode.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pl.minicode.domain.DocumentPage;
import pl.minicode.repository.PageRepository;
import pl.minicode.service.IPageService;
@Service
public class PageService implements IPageService {

	@Autowired
	PageRepository pageRepository;

	@Override
	public List<DocumentPage> findAll() {
		return (List<DocumentPage>) pageRepository.findAll();
	}

	@Override
	public DocumentPage findById(Long id) throws EntityNotFoundException {
		return pageRepository.findById(id).orElseThrow(() -> throwEntityNotFoundException(id));
	}

	@Override
	public DocumentPage save(DocumentPage entity) {
		return pageRepository.save(entity);
	}

	@Override
	public DocumentPage update(DocumentPage entity) {
		return pageRepository.save(entity);
	}

	@Override
	public DocumentPage delete(DocumentPage entity) {
		return save(entity);
	}

	@Override
	public EntityNotFoundException throwEntityNotFoundException(Long id) {
		return new EntityNotFoundException("PAGE: Not found entity with given id:" + id);
	}

	@Override
	public Page<DocumentPage> findAll(Pageable pageable) {
		return pageRepository.findAll(pageable);
	}

}
