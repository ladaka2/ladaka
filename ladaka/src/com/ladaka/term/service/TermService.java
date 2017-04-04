package com.ladaka.term.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladaka.term.dao.TermDao;

@Service
public class TermService {

	@Autowired
	TermDao termDao;
}
