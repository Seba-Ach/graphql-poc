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
public class AuthorQueryResolverTest {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void authorDataSerialization() throws IOException, JSONException {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("request/author-query.graphqls");
        assertThat(graphQLResponse.isOk(), equalTo(true));
        assertEquals(FileReaderUtil.read("response/author-response.json"), graphQLResponse.getRawResponse().getBody(), true);
    }

    @Test
    public void createAuthorMutationDataSerialization() throws IOException, JSONException {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource("request/createAuthor-query.graphqls");
        assertThat(graphQLResponse.isOk(), equalTo(true));
        assertEquals(FileReaderUtil.read("response/createAuthor-response.json"), graphQLResponse.getRawResponse().getBody(), true);
    }

}
