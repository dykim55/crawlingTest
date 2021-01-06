package com.cyberone.cams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class ObjectRepository {

    private final Logger logger = LoggerFactory.getLogger(ObjectRepository.class);

    @Resource
    RestHighLevelClient client;

    public ObjectRepository(RestHighLevelClient client) {
    	this.client = client;
	}

    public List<Map<String, Object>> findObjectList(Map<String, Object> params) throws Exception {

    	List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
    	try {
    		Set<String> keys = params.keySet();
    		
    		BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
    		for (String key : keys) {
    			boolQueryBuilder.must(QueryBuilders.termQuery(key, params.get(key)));
    		}

    		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    		searchSourceBuilder.query(boolQueryBuilder);
    		searchSourceBuilder.size(10000);

    		SearchRequest searchRequest = new SearchRequest()
    				.indices(AliasName.OBJECT.getAliasName())
    				.types(TypeName.MGR_TYPE.getName())
    				.source(searchSourceBuilder)
    				.scroll(TimeValue.timeValueMinutes(1l));

    		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            SearchHit[] searchHitArr = searchHits.getHits();

           	if (searchHitArr != null && searchHitArr.length > 0) {
           		Map<String, Object> result = null;
               	for (SearchHit searchHit : searchHitArr) {
               		result = searchHit.getSourceAsMap();
               		result.put(Mgr._ID.getName(), searchHit.getId());
               		results.add(result);
               	}
           	}
    		
    	} catch (ElasticsearchException e) {
    	     if (e.status () == RestStatus.NOT_FOUND) {
    	    	 // 인덱스가 존재하지 않는 경우
    	     } else if (e.status () == RestStatus.CONFLICT) {
    	    	 // 버전 충돌 오류
    	     }
 	    	logger.warn("[findObjectList] ElasticsearchException: {}", e.getMessage());
     		throw e;
    	} catch (Exception e) {
    		logger.error("[findObjectList]", e);
    		throw e;
    	} 
	    return results;
	}    

}