package com.poc.graphql.resolver;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.poc.graphql.FileReaderUtil;
import com.poc.graphql.TestApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
public class AuthorFieldResolverTest {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void authorById_postsCount_DataSerialization() throws IOException, JSONException {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("request/authorById-postsCount-query.graphqls");
        assertThat(graphQLResponse.isOk(), equalTo(true));
        assertEquals(FileReaderUtil.read("response/authorById-postsCount-response.json"), graphQLResponse.getRawResponse().getBody(), true);
    }

}
