package cn.appsys.service.datadictionary;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.datadictionary.DataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;

@Transactional
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

		@Resource
		private DataDictionaryMapper dataDictionaryMapper;

		@Override
		public List<DataDictionary> getDataDictionaryListTypeCode(String typeCode) {
			return dataDictionaryMapper.getDataDictionaryListTypeCode(typeCode);
		}

		
}
