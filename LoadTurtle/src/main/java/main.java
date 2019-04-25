import com.alibaba.fastjson.JSONReader;

import java.io.StringReader;

public class main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
    }

    public static void ReadWithFastJson()
    {
        String jsonString = "{\"array\":[1,2,3],\"arraylist\":[{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"}],\"object\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},\"string\":\"HelloWorld\"}";

        // 如果json数据以形式保存在文件中，用FileReader进行流读取！！
        // path为json数据文件路径！！
        // JSONReader reader = new JSONReader(new FileReader(path));

        // 为了直观，方便运行，就用StringReader做示例！
        JSONReader reader = new JSONReader(new StringReader(jsonString));
        reader.startObject();
        System.out.print("start fastjson");
        while (reader.hasNext())
        {
            String key = reader.readString();
            System.out.print("key " + key);
            if (key.equals("array"))
            {
                reader.startArray();
                System.out.print("start " + key);
                while (reader.hasNext())
                {
                    String item = reader.readString();
                    System.out.print(item);
                }
                reader.endArray();
                System.out.print("end " + key);
            }
            else if (key.equals("arraylist"))
            {
                reader.startArray();
                System.out.print("start " + key);
                while (reader.hasNext())
                {
                    reader.startObject();
                    System.out.print("start arraylist item");
                    while (reader.hasNext())
                    {
                        String arrayListItemKey = reader.readString();
                        String arrayListItemValue = reader.readObject().toString();
                        System.out.print("key " + arrayListItemKey);
                        System.out.print("value " + arrayListItemValue);
                    }
                    reader.endObject();
                    System.out.print("end arraylist item");
                }
                reader.endArray();
                System.out.print("end " + key);
            }
            else if (key.equals("object"))
            {
                reader.startObject();
                System.out.print("start object item");
                while (reader.hasNext())
                {
                    String objectKey = reader.readString();
                    String objectValue = reader.readObject().toString();
                    System.out.print("key " + objectKey);
                    System.out.print("value " + objectValue);
                }
                reader.endObject();
                System.out.print("end object item");
            }
            else if (key.equals("string"))
            {
                System.out.print("start string");
                String value = reader.readObject().toString();
                System.out.print("value " + value);
                System.out.print("end string");
            }
        }
        reader.endObject();
        System.out.print("start fastjson");
    }
}
