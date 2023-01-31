# fake-Scannner

“隐蔽的将目标代码复制到剪切板”

核心功能代码：

```java
//将名为String的字符串放到剪切板Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(String),null);
```

本人应付PTA考试的一种方法
前提：老师明确告知考试会从题库中抽取
准备工作：

1. 将题库全部下载下来，放到一个文件夹里，记住此路径
2. 下载本仓库中“[Scannner - 副本.java](https://github.com/FrRay/fake-Scannner/blob/main/Scannner - 副本.java)”，在23行修改为你的路径
3. 打包为jar包，导入ide
4. 在一个不明显的地方，new Scannner().nextLnt();
5. 运行，输入文件名关键字
6. 然后这文件里的代码就复制到电脑的剪切板里了
7. 也支持自定义路径、根据首字母查询等不再赘述

想说的话：

1. 我就很倒霉，考试抽题是60取5，在我做的32道小抄里竟然一个都没抽到，小伎俩白做了。。。
