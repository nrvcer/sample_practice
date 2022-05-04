import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.Test;

import java.io.IOException;

// 索引操作
public class IndexOps {
    // 创建客户端对象
    private RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(new HttpHost("localhost", 9200, "http"))
    );
    // 1.创建索引
    @Test
    public void testIndexCreate() throws IOException {

        // 创建索引的请求对象, user为索引名
        CreateIndexRequest request = new CreateIndexRequest("user");
        // 发送请求获取响应
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        // 响应状态
        System.out.println("响应状态：" + acknowledged);

    }
    // 2.删除索引
    @Test
    public void testIndexDelete() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("user");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("响应状态:" + response.isAcknowledged());
    }
}
