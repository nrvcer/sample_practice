import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrvcer.domain.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;

// 文档操作
public class DocOps {
    // 创建客户端对象
    private RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(new HttpHost("localhost", 9200, "http"))
    );
    // 1.新增文档：创建数据，添加到文档中
    @Test
    public void testDocCreate() throws IOException {
        // 新增文档的请求对象
        IndexRequest request = new IndexRequest();
        // 设置索引和唯一性标识
        IndexRequest id = request.index("user").id("1001");
        // 创建数据对象
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setSex("男");
        // 添加文档数据，数据格式为 JSON 格式
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(user);
        request.source(jsonString, XContentType.JSON);
        // 客户端发送请求，获取响应对象
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_id" + response.getId());
        System.out.println("_result" + response.getResult());
    }
    // 2.修改文档
    @Test
    public void testAlterDoc() throws IOException {
        // 修改文档的请求对象,配置修改参数
        UpdateRequest request = new UpdateRequest("user", "1001");
        // 设置请求体，对数据进行修改
        request.doc(XContentType.JSON, "sex", "女");
        // 客户端发送请求，获取响应对象
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_id:" + response.getId());
        System.out.println("_result:" + response.getResult());
    }
    // 3.查询文档
    @Test
    public void testDocQuery() throws IOException {
        //1.创建请求对象
        GetRequest request = new GetRequest("user", "1001");
        //2.客户端发送请求，获取响应对象
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        //3.打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_type:" + response.getType());
        System.out.println("_id:" + response.getId());
        System.out.println("source:" + response.getSourceAsString());
    }
    // 4.删除文档
    @Test
    public void testDocDelete() throws IOException {
        //创建请求对象
        DeleteRequest request = new DeleteRequest().index("user").id("1001");
        //客户端发送请求，获取响应对象
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        //打印信息
        System.out.println(response.toString());
    }
    // 5.批量新增文档数据
    @Test
    public void testDocBatchCreate() throws IOException {
        //创建批量新增请求对象
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name",
                "zhangsan"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name",
                "lisi"));
        request.add(new
                IndexRequest().index("user").id("1003").source(XContentType.JSON, "name",
                "wangwu"));
        //客户端发送请求，获取响应对象
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("took:" + responses.getTook());
        System.out.println("items:" + responses.getItems().length);

    }
    // 6.批量删除文档数据
    @Test
    public void testDocBatchDelete() throws IOException {
        //创建批量删除请求对象
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest().index("user").id("1001"));
        request.add(new DeleteRequest().index("user").id("1002"));
        request.add(new DeleteRequest().index("user").id("1003"));
        //客户端发送请求，获取响应对象
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        //打印结果信息
        System.out.println("took:" + responses.getTook());
        System.out.println("items:" + responses.getItems().length);
    }
}
