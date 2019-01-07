package xw.gank.info;

import java.util.List;

/**
 * Created by Administrator on 2018/5/30.
 */

public class BookBean {

    /**
     * count : 20
     * start : 0
     * total : 21992
     * books : [{"rating":{"max":10,"numRaters":1560,"average":"8.9","min":0},"subtitle":"C语言描述","author":["维斯"],"pubdate":"2004-1-1","tags":[{"count":1904,"name":"数据结构","title":"数据结构"},{"count":1502,"name":"算法","title":"算法"},{"count":773,"name":"计算机","title":"计算机"},{"count":648,"name":"数据结构与算法分析","title":"数据结构与算法分析"},{"count":601,"name":"编程","title":"编程"},{"count":530,"name":"C","title":"C"},{"count":496,"name":"算法、数据结构","title":"算法、数据结构"},{"count":377,"name":"C语言","title":"C语言"}],"origin_title":"Data Structures and Algorithm Analysis in C:Second Edition","image":"https://img3.doubanio.com/view/subject/m/public/s28015501.jpg","binding":"平装","translator":["冯舜玺"],"catalog":"第1章 引论\n1．1 本书讨论的内容\n1．2 数学知识复习\n1．2．1 指数\n1．2．2 对数\n1．2．3 级数\n1．2．4 模运算\n1. 2．5 证明方法\n1．3 递归简论\n总结\n练习\n参考文献\n第2章 算法分析\n2．1 数学基础\n2．2 模型\n2．3 要分析的问题\n2．4 运行时间计算\n2．4．1 一个简单的例子\n2．4．2 一般法则\n2．4．3 最大子序列和问题的解\n.2．4．4 运行时间中的对数\n2．4．5 检验你的分析\n2．4．6 分析结果的准确性\n总结\n练习\n参考文献\n第3章 表、栈和队列\n3．1 抽象数据类型(adt)\n3．2 表adt\n3．2．1 表的简单数组实现\n3．2．2 链表\n3．2．3 程序设计细节\n3．2．4 常见的错误\n3．2．5 双链表\n3．2．6 循环链表\n3．2．7 例子\n3．2．8 链表的游标实现\n3．3 栈adt\n3．3．1 栈模型\n3．3．2 栈的实现\n3．3．3 应用\n3．4 队列adt\n3．4．1 队列模型\n3．4．2 队列的数组实现\n3．4．3 队列的应用\n总结\n练习\n第4章 树\n4．1 预备知识\n4．1．1 树的实现\n4．1．2 树的遍历及应用\n4．2 二叉树\n4．2．1 实现\n4．2．2 表达式树\n4．3 查找树adt--二叉查找树\n4．3．1 makeempty\n4．3．2 find\n4．3．3 findmin和findmax\n4．3．4 insert\n4．3．5 delere\n4．3．6 平均情形分析\n4．4 avl树\n4．4．1 单旋转\n4．4．2 双旋转\n4．5 伸展树\n4．5．1 一个简单的想法\n4．5．2 展开\n4．6 树的遍历\n4．7 b-树\n总结\n练习\n参考文献\n第5章 散列\n5．1 一般想法\n5．2 散列函数\n5．3 分离链接法\n5．4 开放定址法\n5．4．1 线性探测法\n5．4．2 平方探测法\n5．4．3 双散列\n5．5 再散列\n5．6 可扩散列\n总结\n练习\n参考文献\n第6章 优先队列(堆)\n6．1 模型\n6．2 一些简单的实现\n6．3 二叉堆\n6．3．1 结构性质\n6．3．2 堆序性质\n6．3．3 基本的堆操作\n6．3．4 其他的堆操作\n6．4 优先队列的应用\n6．4．1 选择问题\n6．4．2 事件模拟\n6．5 d-堆\n6．6 左式堆\n6．6．1 左式堆的性质\n6．6．2 左式堆的操作\n6．7 斜堆\n6．8 二项队列\n6．8．1 二项队列结构\n6．8．2 二项队列操作\n6．8．3 二项队列的实现\n总结\n练习\n参考文献\n第7章 排序\n7．1 预备知识\n7．2 插入排序\n7．2．1 算法\n7．2．2 插入排序的分析\n7．3 一些简单排序算法的下界\n7. 4 希尔排序\n7．4．1 希尔排序的最坏情形分析\n7．5 堆排序\n7．5．1 堆排序的分析\n7．6 归并排序\n7．6．1 归并排序的分析\n7．7 快速排序\n7．7．1 选取枢纽元\n7．7．2 分割策略\n7．7．3 小数组\n7．7．4 实际的快速排序例程\n7．7．5 快速排序的分析\n7．7．6 选择的线性期望时间算法\n7．8 大型结构的排序\n7．9 排序的一般下界\n7．9．1 决策树\n7．10 桶式排序\n7．11 外部排序\n7．11．1 为什么需要新的算法\n7．11．2 外部排序模型\n7．11．3 简单算法\n7．11．4 多路合并\n7．11．5 多相合并\n7．11．6 替换选择\n总结\n练习\n参考文献\n第8章 不相交集adt\n8．1 等价关系\n8．2 动态等价性问题\n8．3 基本数据结构\n8．4 灵巧求并算法\n8．5 路径压缩\n8．6 按秩求并和路径压缩的最坏情形\n8．6．1 union／find算法分析\n8．7 一个应用\n总结\n练习\n参考文献\n第9章 图论算法\n9．1 若干定义\n9．1．1 图的表示\n9．2 拓扑排序\n9．3 最短路径算法\n9．3．1 无权最短路径\n9．3．2 dijkstra算法\n9．3．3 具有负边值的图\n9．3．4 无圈图\n9．3．5 所有点对最短路径\n9．4 网络流问题\n9．4．1 一个简单的最大流算法\n9．5 最小生成树\n9．5．1 prim算法\n9．5．2 kruskal算法\n9．6 深度优先搜索的应用\n9．6．1 无向图\n9．6．2 双连通性\n9．6．3 欧拉回路\n9．6．4 有向图\n9．6．5 查找强分支\n9．7 np-完全性介绍\n9．7．1 难与易\n9．7．2 np类\n9．7．3 np-完全问题\n总结\n练习\n参考文献\n第10章 算法设计技巧\n10．1 贪婪算法\n10．1．1 一个简单的调度问题\n10．1．2 huffman编码\n10．1．3 近似装箱问题\n10．2 分治算法\n10．2．1 分治算法的运行时间\n10．2．2 最近点问题\n10．2．3 选择问题\n10．2．4 一些运算问题的理论改进\n10．3 动态规划\n10．3．1 用一个表代替递归\n10．3．2 矩阵乘法的顺序安排\n10．3．3 最优二叉查找树\n10．3．4 所有点对最短路径\n10．4 随机化算法\n10．4．1 随机数发生器\n10．4．2 跳跃表\n10．4．3 素性测试\n10．5 回溯算法\n10．5．1 收费公路重建问题\n10．5．2 博弈\n总结\n练习\n参考文献\n第11章 摊还分析\n11．1 一个无关的智力问题\n11．2 二项队列\n11．3 斜堆\n11．4 斐波那契堆\n11．4．1 切除左式堆中的节点\n11．4．2 二项队列的懒惰合并\n11．4．3 斐波那契堆操作\n11．4．4 时间界的证明\n11. 5 伸展树\n总结\n练习\n参考文献\n第12章 高级数据结构及其实现\n12．1 自顶向下伸展树\n12．2 红黑树\n12．2．1 自底向上插入\n12．2．2 自顶向下红黑树\n12．2．3 自顶向下删除\n12．3 确定性跳跃表\n12．4 aa-树\n12．5 treap树\n12．6 k-d树\n12．7 配对堆\n总结\n练习\n参考文献\n索引","pages":"391","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s28015501.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s28015501.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s28015501.jpg"},"alt":"https://book.douban.com/subject/1139426/","id":"1139426","publisher":"机械工业出版社","isbn10":"711112748X","isbn13":"9787111127482","title":"数据结构与算法分析","url":"https://api.douban.com/v2/book/1139426","alt_title":"Data Structures and Algorithm Analysis in C:Second Edition","author_intro":"Mark Allen Weiss，1987年在普林斯顿大学获得计算机科学博士学位，师从Robert Sedgewick (师从Knuth)，现任美国佛罗里达国际大学计算与信息科学学院教授。他曾经担任全美AP(Advanced Placement)考试计算机学科委员会的主席(2000-2004)。他的主要研究方向是数据结构、算法和教育学。","summary":"本书是《Data Structures and Algorithm Analysis in C》一书第2版的简体中译本。原书曾被评为20世纪顶尖的30部计算机著作之一，作者Mark Allen Weiss在数据结构和算法分析方面卓有建树，他的数据结构和算法分析的著作尤其畅销，并受到广泛好评．已被世界500余所大学用作教材。\n在本书中，作者更加精炼并强化了他对算法和数据结构方面创新的处理方法。通过C程序的实现，着重阐述了抽象数据类型的概念，并对算法的效率、性能和运行时间进行了分析。\n全书特点如下：\n●专用一章来讨论算法设计技巧，包括贪婪算法、分治算法、动态规划、随机化算法以及回溯算法\n●介绍了当前流行的论题和新的数据结构，如斐波那契堆、斜堆、二项队列、跳跃表和伸展树\n●安排一章专门讨论摊还分析，考查书中介绍的一些高级数据结构\n●新开辟一章讨论高级数据结构以及它们的实现，其中包括红黑树、自顶向下伸展树。treap树、k-d树、配对堆以及其他相关内容\n●合并了堆排序平均情况分析的一些新结果\n本书是国外数据结构与算法分析方面的标准教材，介绍了数据结构(大量数据的组织方法)以及算法分析(算法运行时间的估算)。本书的编写目标是同时讲授好的程序设计和算法分析技巧，使读者可以开发出具有最高效率的程序。 本书可作为高级数据结构课程或研究生一年级算法分析课程的教材，使用本书需具有一些中级程序设计知识，还需要离散数学的一些背景知识。","series":{"id":"1163","title":"计算机科学丛书"},"price":"35.00元"},{"rating":{"max":10,"numRaters":2088,"average":"9.3","min":0},"subtitle":"隐匿在计算机软硬件背后的语言","author":["[美] Charles Petzold"],"pubdate":"2010","tags":[{"count":2134,"name":"计算机","title":"计算机"},{"count":1297,"name":"计算机科学","title":"计算机科学"},{"count":1212,"name":"计算机原理","title":"计算机原理"},{"count":972,"name":"编程","title":"编程"},{"count":867,"name":"编码","title":"编码"},{"count":615,"name":"科普","title":"科普"},{"count":432,"name":"底层探索","title":"底层探索"},{"count":312,"name":"技术","title":"技术"}],"origin_title":"Code: The Hidden Language of Computer Hardware and Software","image":"https://img3.doubanio.com/view/subject/m/public/s4379914.jpg","binding":"平装","translator":["左飞","薛佟佟"],"catalog":"第1章 至亲密友\n第2章 编码与组合\n第3章 布莱叶盲文与二进制码\n第4章 手电筒的剖析\n第5章 绕过拐角的通信\n第6章 电报机与继电器\n第7章 我们的十个数字\n第8章 十的替代品\n第9章 二进制数\n第10章 逻辑与开关\n第11章 门\n第12章 二进制加法器\n第13章 如何实现减法\n第14章 反馈与触发器\n第15章 字节与十六进制\n第16章 存储器组织\n第17章 自动操作\n第18章 从算盘到芯片\n第19章 两种典型的微处理器\n第20章 ASCII码和字符转换\n第21章 总线\n第22章 操作系统\n第23章 定点数和浮点数\n第24章 高级语言与低级语言\n第25章 图形化革命","pages":"392","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s4379914.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s4379914.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s4379914.jpg"},"alt":"https://book.douban.com/subject/4822685/","id":"4822685","publisher":"电子工业出版社","isbn10":"7121106108","isbn13":"9787121106101","title":"编码","url":"https://api.douban.com/v2/book/4822685","alt_title":"Code: The Hidden Language of Computer Hardware and Software","author_intro":"Charles Petzold从1984年开始编写个人计算机程序，从1985年开始编写 Microsoft Windows程序。他在《Microsoft Systems Joumal》1986年 12月号上发表了第一篇关于Windows程序设计的杂志论文。从1986年到1995年，他为《PC Magazine》撰写\u201cEnvironments\u201d专栏，给读者介绍了Windows和OS／2程序设计的许多方面。\n1994年5月，Petzold作为仅有的七个人之一（并且是唯一的作家）被《Window Magazine》和Microsoft公司授予Windows Pioneer奖，以表彰他对 Microsoft Windows的成功做出的贡献。","summary":"本书讲述的是计算机工作原理。作者用丰富的想象和清晰的笔墨将看似繁杂的理论阐述得通俗易懂，你丝毫不会感到枯燥和生硬。更重要的是，你会因此而获得对计算机工作原理较深刻的理解。这种理解不是抽象层面上的，而是具有一定深度的。","price":"55.00元"},{"rating":{"max":10,"numRaters":610,"average":"8.6","min":0},"subtitle":"人类语言进化的奥秘","author":["[美]史蒂芬·平克"],"pubdate":"2015-5-1","tags":[{"count":700,"name":"语言学","title":"语言学"},{"count":450,"name":"心理学","title":"心理学"},{"count":256,"name":"语言","title":"语言"},{"count":256,"name":"科普","title":"科普"},{"count":218,"name":"思维","title":"思维"},{"count":204,"name":"史迪芬·平克","title":"史迪芬·平克"},{"count":154,"name":"史蒂芬·平克","title":"史蒂芬·平克"},{"count":118,"name":"进化","title":"进化"}],"origin_title":"The Language Instinct：How the Mind Creates Language","image":"https://img1.doubanio.com/view/subject/m/public/s28306448.jpg","binding":"精装","translator":["欧阳明亮"],"catalog":"赞誉/I\n专访史蒂芬· 平克   /V\n前言  语言的无限魅力  /VII\n引言  语言是人的一种本能   /001\n神奇的语言是如何产生的呢？大多数受过教育的人都认为，语言是人类最重要的一项文化创造。达尔文认为语言是\u201c掌握一项技艺的本能倾向\u201d，威廉 · 詹姆斯则认为语言和思想都是人的本能。乔姆斯基的\u201c普遍语法\u201d理论，是20世纪关于语言本能的最著名论断。\n◆ 神奇的语言\n◆ \u201c文化创造\u201d论\n◆ \u201c语言本能\u201d论\n◆ 乔姆斯基的\u201c普遍语法\u201d\n01  有人类存在的地方，就有语言存在   /013\n我们本以为语言是文化的产物，错误地认为教育程度偏低人群的语言表达能力也会差一些。但实际上，美国黑人在英语表达方面却更胜一筹。语言的普遍性，并不意味着语言就是人的本能，我们还要观察语言的进化过程。大脑，是语言产生的生物学基础。\n◆ 黑人英语更高明\n◆ 语言普遍性≠语言即本能\n◆ 从无到有的克里奥尔语\n◆ 大脑，语言的生物学基础\n02  心语   /045\n人们很容易高估语言的能力，以为语言决定着我们的思维。实际上，语言不是思维的唯一方式。心智计算理论是认知科学的基础，无论是英语还是其他任何自然语言，都不能用作心智计算的介质。心语，才是思维的语言。\n◆ 语言不是思维的唯一方式\n◆ 心智计算理论\n◆ 英语不适于心智计算的5大原因\n◆ 心语才是思维语言\n03  语言机制   /075\n我们每个人的大脑中都装有一部\u201c心理词典\u201d和一套\u201c心理语法\u201d，语言就是用语法规则组合起来的词语。若想领悟乔姆斯基的语言机制理论，我们首先要弄清这个理论是解决什么问题的。有些语法规则在婴儿诞生之初就存在于他们的大脑中，他们是天生的\u201c语法专家\u201d。\n◆ 心理词典和心理语法\n◆ 只有上帝才能造出一颗树\n◆ 乔姆斯基的语言机制理论\n◆ 有些语法规则是天生的\n04  每个人的头脑中都装着一套构词法   /123\n通过构词法，人们就可以将词根扩展为词干，将词干扩展为词语，从而创造出千千万万的词语。符号与意义之间的关系深深地扎根于儿童的头脑中。我们的心智天生就是为了发现这个世界上所存在的各式各样的物体和运动，并用单词来一一标记它们。\n◆ 形形色色的构词法和不计其数的单词\n◆ 词根，词干的最小组成部分\n◆ 是Walkmen，还是Walkmans？\n◆ 单词的记忆过程\n05  语音的奥秘   /159\n我们有喉头、软腭、舌面、舌尖、舌根、双唇六个语音器官，再结合喉头是否振动、软腭张闭、舌根是否紧张以及双唇是否撮起，我们在英语中就可以形成40个音素。不同语言的语音模式也千差万别。语音之所以难以识别，是因为人类的大脑和口头之间存在许多不相配的地方。\n◆ 元音和辅音\n◆ 发音器官的组合方式\n◆ 语音模式\n◆ 为什么语音识别如此之难\n06  会说话的大脑   /197\n在科学家看来，人脑对语言的理解能力实在超乎想象。人们几乎可以\u201c同步\u201d完成接收和理解语言这一极其复杂的任务。记忆负担轻的语言，才是好语言；不产生歧义的句子，才是好句子。语迹，是理解语言的必要心理活动，脑电图证实了这种记忆负担的存在。\n◆ 人脑对语言的理解能力超乎想象\n◆ 记忆负担轻的语言，才是好语言\n◆ 不产生歧义的句子，才是好句子\n◆ 语迹，理解语言的必要心理活动\n07  为什么地球上会存在那么多不同的语言   /241\n目前，世界上仍有5 000多种不同的语言存在。从单词和语素的排列次序角度看，这些语言至少有45个共同点。无论哪一种语言，我们都能轻松找出几十个独特的地方。遗传、变异、隔离是导致语言差异的三大原因。在不远的将来，人类大多数语言都将彻底消失。\n◆ 语言的共性与差异\n◆ 导致语言差异的三大原因（遗传、变异、隔离）\n◆ 语言的源头\n◆ 令人担忧的未来：大多数语言都将消失\n08 孩子天生会说话   /273\n所有的婴儿都是带着语言能力来到这个世界的，他们3～4岁就能自如运用语言。声音环境、母亲式语型、父母的回应与自我实践，是儿童学会语言的3大要素。人的语言能力与大脑发育是直接相关的。婴儿大脑的代谢能力，在4岁左右达到峰值。6岁之前，是学习语言的最佳年龄。\n◆ 儿童是学习语言的天才\n◆ 儿童学会语言的3大要素\n◆ 语言能力与大脑发育\n◆ 6岁之前，学习语言的最佳年龄\n09  语言器官和语法基因   /313\n神经科学家在左脑发现了语言运作的痕迹。在所有由脑损伤引发的语言障碍中，损伤部位位于左侧大脑外侧裂周区的病例占到98%，因此，我们可以称这一区域是人类的\u201c语言器官\u201d。有些基因似乎会对处理语法的神经回路产生特定影响，这为语法基因的存在提供了间接证据。\n◆ 我们都在用左脑说话\n◆ 人类的\u201c语言器官\u201d：左侧大脑外侧裂周区\n◆ 语法基因存在的间接证据\n◆ 语言的遗传与变异\n10  人类语言的起源   /349\n人类语言就如同大象的鼻子，是自然界中一个非常独特的存在。黑猩猩是人类的近亲，但他们的语言能力远不及婴儿。语言并非产生于\u201c大爆炸\u201d，这只不过是一种错觉，因为我们那些懂一些语言的祖先都已灭绝了。人类语言已有400万年的进化历程，我们的语言能力是自然选择的结果。\n◆ 大象的鼻子\n◆ 黑猩猩的语言能力为什么远不如婴儿\n◆ 语言能力\u201c大爆炸\u201d只是一种错觉\n◆ 从0到1，语言的进化\n11  语言专家   /389\n每个人说出的话，从语言机制的角度看可能合乎语法，从规定性的角度看又可能不合乎语法，\u201c双重否定\u201d就是最好的例子。对于这一问题，众多的语言专家各有高见。其实，对已经成为社会标准的方言，甚至俚语，我们都应该多学多用。在语言运用方面，最应该改善的是写作的明晰和文体的得当。\n◆ 规定性规则与描述性规则\n◆ 几个正确的\u201c错误\u201d\n◆ 4类语言专家的高见\n◆ 我们该怎么办\n结语  语言，洞悉人性的一扇窗   /427\n语言本能既源于遗传，也离不开环境的影响。受乔姆斯基的\u201c普遍语法\u201d的启发，人们将会找到潜藏于所有文化下的普遍行为模式。按\u201c相似度\u201d进行归纳，是人类天生就有的一种学习能力。尽管我们说着不同的语言，但我们拥有相同的心智结构，语言是洞悉人性的一扇窗。\n◆ 语言本能离不开遗传和环境\n◆ 从普遍语法到普遍人性\n◆ \u201c相似度\u201d归纳，人类天生的学习能力\n◆ 不同的语言，相同的心智结构\n附录  \u201c语言本能\u201d的研究进展    / 453\n译者后记    / 469","ebook_url":"https://read.douban.com/ebook/29284541/","pages":"492","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s28306448.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s28306448.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s28306448.jpg"},"alt":"https://book.douban.com/subject/26380736/","id":"26380736","publisher":"浙江人民出版社","isbn10":"7213066552","isbn13":"9787213066559","title":"语言本能","url":"https://api.douban.com/v2/book/26380736","alt_title":"The Language Instinct：How the Mind Creates Language","author_intro":"史蒂芬·平克，出生于加拿大蒙特利尔，1976年取得麦吉尔大学心理学学士学位，1979年取得哈佛大学实验心理学博士学位。\n1982年\u20142003年，在麻省理工学院脑与认知科学系任教，并专心研究儿童的语言学习模式，并最终成为麻省理工学院认知神经学中心的掌门人。1994年，他的《语言本能》一经出版，就成为轰动一时的畅销书，并入选《美国科学家》（American Scientist）评出的20世纪100本最佳科学书籍。\n2003年，被聘为哈佛大学心理学教授。2008年\u20142013年，被授予哈佛学院荣誉教授头衔。\n2004年，当选《时代》杂志全球100位最有影响力人物。2010年\u20142011年，两度被《外交政策》杂志评为全球顶尖思想家。在2013年《前景》杂志\u201c最伟大思想家\u201d的评选中，平克名列第3。","summary":"一扇了解语言器官、破解语法基因、进入人类心智的大门；\n一个关于语言问题最权威的答案；\n一些令人信服、生动有趣的例证；\n一场常识对谬论的彻底胜利。","ebook_price":"87.99","series":{"id":"40200","title":"语言与人性四部曲"},"price":"109.90元"},{"rating":{"max":10,"numRaters":534,"average":"8.0","min":0},"subtitle":"探索人类语言进化的奥秘","author":["史迪芬·平克"],"pubdate":"2004-01","tags":[{"count":1454,"name":"语言学","title":"语言学"},{"count":517,"name":"心理学","title":"心理学"},{"count":483,"name":"语言","title":"语言"},{"count":319,"name":"科普","title":"科普"},{"count":250,"name":"思维","title":"思维"},{"count":126,"name":"哲学","title":"哲学"},{"count":98,"name":"linguistics","title":"linguistics"},{"count":88,"name":"科学","title":"科学"}],"origin_title":"The Language Instinct: How the Mind Creates Language","image":"https://img3.doubanio.com/view/subject/m/public/s1004571.jpg","binding":"平装","translator":["洪兰"],"catalog":"＜出版缘起＞开创科学新视野\n＜专文推荐＞进化论里的语言本能\n＜中文版序＞语言的奇迹\n＜译者序＞语言是社会化的基本条件\n＜作者序＞写给所有使用语言的人\n第1章语言习得的本能\n我们只要张开嘴、发出声音，就可以将彼此心中的意念，很准确地传到对方心中。这个能力来得如此自然、轻松，我们常常忘记拥有这个能力其实是个奇迹。\n第2章喋喋不休\n语言复杂性的这种普遍现象，常使语言学家感到敬畏。这也是我们怀疑语言不是文化产物，而是人类犄殊本能产物的第一个原因。\n第3章思想的语言\n思想语言一定比口语来得简单，特定谈话的字和结构都没有了；没有语言的人还是可以有思想的语言。所以，习得一种语言就是知道如何将思想语言翻译成一串的字，或是将一串字转换成思想。\n第4章语言的运作\n语言的运作方式是：每一个人的脑海中有一种字汇（心理词汇）及概念（心理语法）的组合；这套规则可以把字组合起来，并将概念之间的关系传递出去。\n","pages":"490","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s1004571.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1004571.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1004571.jpg"},"alt":"https://book.douban.com/subject/1007073/","id":"1007073","publisher":"汕头大学出版社","isbn10":"7810365886","isbn13":"9787810365888","title":"语言本能","url":"https://api.douban.com/v2/book/1007073","alt_title":"The Language Instinct: How the Mind Creates Language","author_intro":"史迪芬・平克（Steven Pinker）\n麻省理工学院教授、认知神经科学主任，他的研究曾获得多种奖项。他是公认继乔姆斯基之后的语言大才，也是世界语言学与心智科学的领导人物。《语言本能》甫出版，就登上了《纽约时报》的畅销书榜；同时也奠定了平克在MIT的地位。\n","summary":"一本由真正的专家所写的关于语言的书，可读性非常高。平克非常技巧地把一个想知道的语言问题提出来讨论，不但从语言学、心理学的专业知识去着手，他还有深厚的生物学知识。最主要的是，他知道一般人对于语言学上的问题在哪里，以四两拨千斤的轻松方式，拨开云雾见青天，把人们带出牛角尖。不管这本书将来在语言学和心理学上的影响为何，《语言本能》这本书已经在科学普及方面立下了不朽的功劳。平克的这本书，无疑地会使读者开始尊敬对这个令人惊奇的自然现象\u2014\u2014语言。","series":{"id":"8570","title":"科学新视野"},"price":"39.80元"},{"rating":{"max":10,"numRaters":244,"average":"8.3","min":0},"subtitle":"语言是洞察人类天性之窗","author":["史蒂芬·平克 (Steven Pinker)"],"pubdate":"2015-8-1","tags":[{"count":421,"name":"心理学","title":"心理学"},{"count":308,"name":"语言学","title":"语言学"},{"count":276,"name":"史蒂芬·平克","title":"史蒂芬·平克"},{"count":235,"name":"思维","title":"思维"},{"count":127,"name":"科普","title":"科普"},{"count":123,"name":"社会学","title":"社会学"},{"count":117,"name":"心理","title":"心理"},{"count":99,"name":"思维与实践","title":"思维与实践"}],"origin_title":"The Stuff of Thought","image":"https://img3.doubanio.com/view/subject/m/public/s28277341.jpg","binding":"精装","translator":["张旭红","梅德明"],"catalog":"前言 语言是洞察人类天性之窗 /I\n引言 语言,表达思想和情感的媒介 / 001\n语言是人们表达思想和情感的媒介,但并不等同于思想和 情感本身。用含蓄的语言进行贿赂或威胁,更便于日后推 卸责任;而一个巧妙的祈使句可以把\u201c命令\u201d包装成\u201c请求\u201d。说脏话是宣泄极端情感的常用方式; 而一句\u201c你知道我是谁吗\u201d,则可凸显自己优越的社会地位。\n思想是思想,语言是语言\n布什是否说了谎,Learned 这个词是关键\n名字透露出的重要信息\n人为什么一激动就爱讲脏话\n你知道我是谁吗\n第二部分 语言与思想\n01 动词的奥秘 / 031\n动词不仅可以将句子的核心成分组合起来,而且在很大程 度上决定了句子的意思。儿童善于在学习动词时发现潜在 模式,并将其扩展到对其他动词的使用上。不过,过度泛 化规则也会让儿童误入歧途。人类的心智具有用截然不同 的方式框架同一起事件的能力。对于我们的一些创造性应 用,有些还没有被大众接受,另一些则在反复应用中得到了大众的认可,我们的语言就是这样不断变化和发展的。\n动词决定句子的意思\n相同的场景,不同的框架\n动词与思想 1:内容移动,还是容器状态改变\n动词与思想 2:使其移动,还是使谁拥有它\n动词与思想 3:及物动词,还是不及物动词\n第二部分 语言与现实\n02 一个人真的天生有5万个概念吗 / 107\n极端天赋论认为,人类天生就具有大约 5 万个概念,而词 义无法再被分解成更基本的概念。激进语用学认为,在不 同语境下,人们可以用同一个词表达不同的东西。而对于 语言决定论者来说,人们所使用的语言就是思想的语言。 实际上,语言是一扇通往人性的窗口,透过语言,人类思 想情感的深层普遍特征将被一览无遗,但是,思想和情感 并不等同于语言本身。\n极端天赋论\n激进语用学\n语言决定论\n03 空间、时间和因果关系 / 181\n空间、时间、因果关系是人类赖以思考的三大基础结构, 但我们却无法真正理解它们。尽管我们体验中的空间和时 间都是连续的,但在用语言所表达的时空模型中,语言却 不是模拟介质而是典型的数字介质。解读人性的认知模型, 都是根据人们的需要打造出来的,因此,我们会以对自己 有利的方式操纵物理环境和归因道德责任,而我们的日常 生活也因此多姿多彩。\n物体思维和物质思维\n空间思维\n时间思维\n因果关系思维\n04 隐喻之隐喻 / 275\n\u201c煞风景论\u201d认为,语言中的绝大多数都是死喻,人们早 已不记得它们的原始含义。\u201c弥赛亚论\u201d认为,思想是对 隐喻的领会,也就是\u201c隐喻之隐喻\u201d。\u201c朱丽叶是太阳\u201d是 一种充满诗情画意的隐喻,而\u201c爱即旅程\u201d则属于\u201c概念 隐喻\u201d。概念隐喻为人们指明了一种最显而易见的方法, 人们据此可以学会如何推理出一个全新的、抽象的概念。 隐喻是开启人类思想和语言的金钥匙。\n煞风景论与弥赛亚论\n隐喻的重要作用\n隐喻的背后\n隐喻与心智\n第三部分 语言与社团\n05 名为何物 / 327\n任何一个人名或事物名称都是先由人类历史上某个时期的 某个人物凭空杜撰出来,并在随后被语言社团接受并流传 开来的。正是这一过程将我们的世界、心智以及人类社会 以一种令人惊奇的方式网罗在了一起。命名这种谦逊的行 为,一方面颠覆了我们对逻辑、含义以及知识与现实之 间的关系的认识;另一方面也颠覆了我们对文化和社会的 认识。\n词的含义栖身何处\n新词是如何创造出来的\n未命名,还是无以为名\n引爆流行的神秘力量\n第四部分 语言与群体\n06 7个电视禁忌语 / 381\n尽管一些原本干干净净的词语会变得污浊不堪,另一些原 本肮脏下流的词语却被岁月漂洗得一尘不染,但脏话总是 存在的。因为富载情感的禁忌语,最擅长捕获人们的注意 力。Shit、Piss、Fuck、Cunt、Cocksucker、Motherfucker 和 Tits 是 7 个饱受争议的电视禁忌语。当咒骂被人们明智 而审慎地使用时,它可以起到搞笑、一针见血、独具匠心 的作用;但过度使用禁忌语,则会削弱它们的情感表现力。\n有语言存在的地方,就有脏话存在\n禁忌语最擅长捕获人们的注意力\n咒骂语义学\n诅咒的 5 种方式\n关于诅咒的利弊权衡\n第四部分 语言与社会关系\n07 直截了当地说话不好吗 / 441\n为了准确传达信息,说话者应该遵守\u201c会话 4 准则\u201d。人 是社会动物,很在意自己留给他人的印象,因此说话拐弯 抹角也是常有的事。一段会话的含义分为字面含义和意欲 传达的信息两层意思。句子的字面含义当然要起一些作用, 但如果意欲传达的信息是消极的,最巧妙的方法就是用积 极的字面含义去传达。我们可以将\u201c命令\u201d包装在\u201c请求\u201d 里,或者用模糊的逻辑在博弈中受益。\n会话 4 准则:数量、质量、方式、关联\n礼貌的逻辑:以请求的方式下达命令\n模糊的逻辑:在博弈中受益\n人际关系的 3 种模式:分享、等级、交易\n结语 逃离心智洞穴,发现真实人性 / 497\n译者后记 / 513","ebook_url":"https://read.douban.com/ebook/29282884/","pages":"514","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s28277341.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s28277341.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s28277341.jpg"},"alt":"https://book.douban.com/subject/26593192/","id":"26593192","publisher":"浙江人民出版社","isbn10":"7213067990","isbn13":"9787213067990","title":"思想本质","url":"https://api.douban.com/v2/book/26593192","alt_title":"The Stuff of Thought","author_intro":"史蒂芬·平克，出生于加拿大蒙特利尔，1976年取得麦吉尔大学心理学学士学位，1979年取得哈佛大学实验心理学博士学位。\n1982\u20142003年，在麻省理工学院脑与认知科学系任教，并专心研究儿童的语言学习模式，并最终成为麻省理工学院认知神经学中心的掌门人。1994年，他的《语言本能》一经出版，就成为轰动一时的畅销书，并入选《美国科学家》评出的20世纪100本最佳科学书籍。\n2003年，被聘为哈佛大学心理学教授。2008\u20142013年，被授予哈佛学院荣誉教授头衔。\n2004年，当选《时代》杂志全球100位最有影响力人物。2010\u20142011年，两度被《外交政策》杂志评为全球顶尖思想家。在2013年《前景》杂志\u201c最伟大思想家\u201d的评选中，平克名列第三。","summary":"一扇进入人类心智的窗户；\n一次针对语言与思想之间的关系最深刻的论述；\n一些令人信服、生动有趣的例证；\n一场思想之本质的探索之旅。","ebook_price":"84.99","series":{"id":"40200","title":"语言与人性四部曲"},"price":"CNY 129.90"},{"rating":{"max":10,"numRaters":686,"average":"8.7","min":0},"subtitle":"深度探索动态语言核心技术","author":["陈儒"],"pubdate":"2008-6","tags":[{"count":1554,"name":"python","title":"python"},{"count":600,"name":"编程","title":"编程"},{"count":478,"name":"Python","title":"Python"},{"count":316,"name":"计算机","title":"计算机"},{"count":247,"name":"编译原理","title":"编译原理"},{"count":237,"name":"程序语言","title":"程序语言"},{"count":226,"name":"programming","title":"programming"},{"count":180,"name":"脚本引擎","title":"脚本引擎"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s3435132.jpg","binding":"平装","translator":[],"catalog":"第0章 Python源码剖析\u2014\u2014编译Python\n0.1 Python总体架构\n0.2 Python源代码的组织\n0.3 Windows环境下编译Python\n0.4 Unix/Linux环境下编译Python\n0.5 修改Python源代码\n0.6 通往Python之路\n0.7 一些注意事项\n第1部分 Python内建对象\n第1章 Python对象初探\n1.1 Python内的对象\n1.2 类型对象\n1.3 Python对象的多态性\n1.4 引用计数\n1.5 Python对象的分类\n第2章 Python中的整数对象\n2.1 初识PyIntObject对象\n2.2 PyIntObject对象的创建和维护\n2.3 Hack PyIntObject\n第3章 Python中的字符串对象\n3.1 PyStringObject与PyString_Type\n3.2 创建PyStringObject对象\n3.3 字符串对象的intern机制\n3.4 字符缓冲池\n3.5 PyStringObject效率相关问题\n3.6 Hack PyStringObject\n第4章 Python中的List对象\n4.1 PyListObject对象\n4.2 PyListObject对象的创建与维护\n4.3 PyListObject对象缓冲池\n4.4 Hack PyListObject\n第5章 Python中的Dict对象\n5.1 散列表概述\n5.2 PyDictObject\n5.3 PyDictObject的创建和维护\n5.4 PyDictObject对象缓冲池\n5.5 Hack PyDictObject\n第6章 最简单的Python模拟\u2014\u2014Small Python\n6.1 Small Python\n6.2 对象机制\n6.3 解释过程\n6.4 交互式环境\n第2部分 Python虚拟机\n第7章 Python的编译结果\u2014\u2014Code对象与pyc文件\n7.1 Python程序的执行过程\n7.2 Python编译器的编译结果\u2014\u2014PyCodeObject对象\n7.3 Pyc文件的生成\n7.4 Python的字节码\n7.5 解析pyc文件\n第8章 Python虚拟机框架\n8.1 Python虚拟机中的执行环境\n8.2 名字、作用域和名字空间\n8.3 Python虚拟机的运行框架\n8.4 Python运行时环境初探\n第9章 Python虚拟机中的一般表达式\n9.1 简单内建对象的创建\n9.2 复杂内建对象的创建\n9.3 其他一般表达式\n第10章 Python虚拟机中的控制流\n10.1 Python虚拟机中的if控制流\n10.2 Python虚拟机中的for循环控制流\n10.3 Python虚拟机中的while循环控制结构\n10.4 Python虚拟机中的异常控制流\n第11章 Python虚拟机中的函数机制\n11.1 PyFunctionObject对象\n11.2 无参函数调用\n11.3 函数执行时的名字空间\n11.4 函数参数的实现\n11.5 函数中局部变量的访问\n11.6 嵌套函数、闭包与decorator\n第12章 Python虚拟机中的类机制\n12.1 Python中的对象模型\n12.2 从type对象到class对象\n12.3 用户自定义class\n12.4 从class对象到instance对象\n12.5 访问instance对象中的属性\n12.6 千变万化的descriptor\n第13章 Python运行环境初始化\n13.1 线程环境初始化\n13.2 系统module初始化\n13.3 激活Python虚拟机\n第14章 Python模块的动态加载机制\n14.1 import前奏曲\n14.2 Python中import机制的黑盒探测\n14.3 import机制的实现\n14.4 Python中的import操作\n14.5 与module有关的名字空间问题\n第15章 Python多线程机制\n15.1 GIL与线程调度\n15.2 初见Python Thread\n15.3 Python线程的创建\n15.4 Python线程的调度\n15.5 Python子线程的销毁\n15.6 Python线程的用户级互斥与同步\n15.7 高级线程库\u2014\u2014threading\n第16章 Python的内存管理机制\n16.1 内存管理架构\n16.2 小块空间的内存池\n16.3 循环引用的垃圾收集\n16.4 Python中的垃圾收集","ebook_url":"https://read.douban.com/ebook/1499455/","pages":"480","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s3435132.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s3435132.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s3435132.jpg"},"alt":"https://book.douban.com/subject/3117898/","id":"3117898","publisher":"电子工业出版社","isbn10":"7121068745","isbn13":"9787121068744","title":"Python源码剖析","url":"https://api.douban.com/v2/book/3117898","alt_title":"","author_intro":"","summary":"作为主流的动态语言，Python不仅简单易学、移植性好，而且拥有强大丰富的库的支持。此外，Python强大的可扩展性，让开发人员既可以非常容易地利用C/C++编写Python的扩展模块，还能将Python嵌入到C/C++程序中，为自己的系统添加动态扩展和动态编程的能力。.\n为了更好地利用Python语言，无论是使用Python语言本身，还是将Python与C/C++交互使用，深刻理解Python的运行原理都是非常重要的。本书以CPython为研究对象，在C代码一级，深入细致地剖析了Python的实现。书中不仅包括了对大量Python内置对象的剖析，更将大量的篇幅用于对Python虚拟机及Python高级特性的剖析。通过此书，读者能够透彻地理解Python中的一般表达式、控制结构、异常机制、类机制、多线程机制、模块的动态加载机制、内存管理机制等核心技术的运行原理，同时，本书所揭示的动态语言的核心技术对于理解其他动态语言，如 Javascript、Ruby等也有较大的参考价值。..\n本书适合于Python程序员、动态语言爱好者、C程序员阅读","ebook_price":"38.39","price":"69.80元"},{"rating":{"max":10,"numRaters":1215,"average":"9.1","min":0},"subtitle":"","author":["[瑞士] 费尔迪南·德·索绪尔"],"pubdate":"1980-11","tags":[{"count":1262,"name":"语言学","title":"语言学"},{"count":658,"name":"索绪尔","title":"索绪尔"},{"count":360,"name":"符号学","title":"符号学"},{"count":317,"name":"结构主义","title":"结构主义"},{"count":247,"name":"哲学","title":"哲学"},{"count":195,"name":"语言","title":"语言"},{"count":161,"name":"语言哲学","title":"语言哲学"},{"count":105,"name":"Saussure","title":"Saussure"}],"origin_title":"Cours de linguistique générale (5th ed., 1949)","image":"https://img3.doubanio.com/view/subject/m/public/s3136456.jpg","binding":"平装","translator":["高名凯"],"catalog":"前言\n第一版序\n第二版序\n第三版序\n緒論\n第一章  語言黨史一瞥\n第二章  語言學的材料和任務;它和毗鄰科學的關係\n第三章  語言學的對象\n第四章  語言的語言學和言語的語言學\n第五章  語言的內部要素和外部要素\n第六章　文字表現語言第七章  音位學\n附錄：　音位學原理\n第一章  音位學的種類\n第二章  語鏈中的音位\n編者附註\n第一編   一般原則\n第一章  語言符號的性質\n第二章  符號的不變性和可變性\n第三章  靜態語言學和演化語言學\n第二編  共時語言學\n第一章  概述\n第二章  語言的具體實體\n第三章  同一性、現實性、價值\n第四章  語言的價值\n第五章  句段關係和聯想關係\n第六章  語言的機構\n第七章  語法及其區分\n第八章  抽象實體在語法中的作用\n第三編  歷時語言學\n第一章  概述\n第二章  語言變化\n第三章  語言演化在語法上的後果\n第四章  類化\n第五章 類比和演化\n第六章  流俗詞源\n第七章  粘合\n第八章  歷時的單位，同一性和現實性\n第三篇和第四篇附錄\n第四編   地理語言學\n第一章  關於語言的差異\n第二章  地理差異的複雜性\n第三章  地理差異的原因\n第四章  語言波浪的傳播\n第五編  回顧語言學的問題  結論\n第一章  歷時語言學的兩種展望\n第二章  最古的語言和原始型\n第三章  重建\n第四章  人類學和史前史中的語言證據\n第五章  語系和語言的類型\n索引\n校後記","ebook_url":"https://read.douban.com/ebook/20076321/","pages":"333","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s3136456.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s3136456.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s3136456.jpg"},"alt":"https://book.douban.com/subject/1433192/","id":"1433192","publisher":"商务印书馆","isbn10":"7100020867","isbn13":"9787100020862","title":"普通语言学教程","url":"https://api.douban.com/v2/book/1433192","alt_title":"Cours de linguistique générale (5th ed., 1949)","author_intro":"本書著者費爾迪南·德·索緒爾是本世紀最著名、影響最深遠的語言學家之一。他在1857年出生於瑞士日內瓦的一個法國人家裡。中學畢業後，於1875至1876年在日內瓦大學讀了一年，其後轉學到德國，在來比錫大學學習語言學。那時正是新語法學派諸語言學家和他們的老師古爾替烏斯（Gurtius）對語言學問題辯論得最激烈的時候。他起初完全站在新語法學派一邊，在奧斯脫霍夫（H.Osthoff）和雷斯琴（A.Leskien）的指導下從事歷史比較語言學研究工作，於1878年寫出他那篇傑出的《論印歐系語言元音的原始系統》，使老一輩的語言學家大為驚奇。接著轉學柏林大學，1880年回來比錫大學考博士學位，1881年到法國巴黎，在高等研究學院教授梵語，同時兼任巴黎語言學學會秘書，在整整十年間培養了梅耶（A.Meillet），格拉蒙（M.Grammont）等語言學家，建成法蘭西學派。1891年離法回國，在日內瓦大學講授梵語和印歐系語言歷史比較研究。1906\u20141907年開始講授普通語言學， 1908\u20141909和1910\u20141911年繼續講授，但是並沒有把它編寫成書。1913年德·索緒爾去世後，他的學生巴利和薛施藹等根據同學們的筆記和德·索緒爾的一些手稿及其它材料編輯整理成《普通語言學教程》一書，於1916年在法國巴黎出第一版，1922年出第二版，1949再出第三版，各國語言學家先後把它譯成德、西、俄、英、日等國文字，使它的影響遍及全世界。","summary":"本書是著者費爾迪南.德.索緒爾是本世紀最著名、影響最深遠的語言學家之一。他在1857年出生於瑞士日內瓦的一個法國人家裡。中學畢業後，於1875年至1876年在日內瓦大學讀了一年，其後轉學到德國，在來比錫大學學習語言學。那時正是新語法學派諸語言學家和他們的教師古爾替烏斯（G.Curtius）對語言學問題辯論得最激烈的時候。他起初完全站在新語法學派一邊，在奧斯脫霍夫（H. Osthoff）和雷斯琴（A. Leskien）的指導下從事歷史比較語言研究工作，於1878年寫出他那篇傑出的《論印歐系語言元音的原始系統》，使老一輩的語言學家大為驚奇。","ebook_price":"16.61","series":{"id":"28","title":"汉译世界学术名著丛书·语言学"},"price":"22.00元"},{"rating":{"max":10,"numRaters":3958,"average":"9.4","min":0},"subtitle":"第 2 版·新版","author":["（美）Brian W. Kernighan","（美）Dennis M. Ritchie"],"pubdate":"2004-1","tags":[{"count":2704,"name":"C","title":"C"},{"count":2032,"name":"c语言","title":"c语言"},{"count":1910,"name":"编程","title":"编程"},{"count":1258,"name":"计算机","title":"计算机"},{"count":1059,"name":"程序设计","title":"程序设计"},{"count":902,"name":"经典","title":"经典"},{"count":744,"name":"编程语言","title":"编程语言"},{"count":658,"name":"C/C++","title":"C/C++"}],"origin_title":"The C Programming Language","image":"https://img3.doubanio.com/view/subject/m/public/s1106934.jpg","binding":"平装","translator":["徐宝文","李志译","尤晋元审校"],"catalog":"出版者的话\n专家指导委员会\n中文版序\n译者序\n校译者简介\n序\n第1版序\n引言\n第1章 导言\n1.1 入门\n1.2 变量与算术表态式\n1.3 for语句\n1.4 符号常量\n1.5 字符输入/输出\n1.6 数组\n1.7 函数\n1.8 参数\u2014\u2014传值调用\n1.9 字符数组\n1.10 外部变量与作用域\n第2章 类型、运算符与表达式\n2.1 变量名\n2.2 数据类型及长度\n2.3 常量\n2.4 声明\n2.5 算术运算符\n2.6 关系运算符与逻辑运算符\n2.7 类型转换\n2.8 自增运算符与自减运算符\n2.9 按位运算符\n2.10 赋值运算符与表达式\n2.11 条件表达式\n2.12 运算符优先级与求值次序\n第3章 控制流\n3.1 语句与程序块\n3.2 if-else语句\n3.3 else-if语句\n3.4 switch语句\n3.5 whil循环与for特环\n3.6 do-while循环\n3.7 break语句与continue语句\n3.8 goto语句与标号\n第4章 涵数与程序结构\n第5章 指针与数组\n第6章 结构\n第7章 输入与输出\n第8章 UNIX系统接口\n附录A 参考手册\n附录B 标准库\n附录C 变更小结\n索引","pages":"258","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s1106934.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1106934.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1106934.jpg"},"alt":"https://book.douban.com/subject/1139336/","id":"1139336","publisher":"机械工业出版社","isbn10":"7111128060","isbn13":"9787111128069","title":"C程序设计语言","url":"https://api.douban.com/v2/book/1139336","alt_title":"The C Programming Language","author_intro":"Brian W. Kernighan： 贝尔实验室计算科学研究中心高级研究人员，著名的计算机科学家。他参加了UNIX系统、C语言、AWK语言和许多其他系统的开发，同时出版了许多在计算机领域具有影响的著作，如《The Elements of Programming Style》、《The Practice of Programming》、《The UNIX Programming Environment》、《The AWK Language》、《Software Tools》等。\nDennis M. Ritchie：1967年加入贝尔实验室。他和Ken L. Thompson两人共同设计并实现的C语言改变了程序设计语言发展的轨迹，是程序设计语言发展过程中的一个重要里程碑。与此同时，他们两人还设计并实现了UNIX操作系统。正是由于这两项巨大贡献，Dennis M. Ritchie于1983年获得了计算机界的最高奖\u2014\u2014图灵奖。此外，他还获得了ACM、IEEE、贝尔实验室等授予的多种奖项.。","summary":"在计算机发展的历史上，没有哪一种程序设计语言像C语言这样应用广泛。本书原著即为C语言的设计者之一Dennis M.Ritchie和著名计算机科学家Brian W.Kernighan合著的一本介绍C语言的权威经典著作。我们现在见到的大量论述C语言程序设计的教材和专著均以此书为蓝本。原著第1版中介绍的C语言成为后来广泛使用的C语言版本\u2014\u2014标准C的基础。人们熟知的\u201chello,World\"程序就是由本书首次引入的，现在，这一程序已经成为众多程序设计语言入门的第一课。\n原著第2版根据1987年制定的ANSIC标准做了适当的修订．引入了最新的语言形式，并增加了新的示例，通过简洁的描述、典型的示例，作者全面、系统、准确地讲述了C语言的各个特性以及程序设计的基本方法。对于计算机从业人员来说，《C程序设计语言》是一本必读的程序设计语 言方面的参考书。","series":{"id":"1163","title":"计算机科学丛书"},"price":"30.00元"},{"rating":{"max":10,"numRaters":2629,"average":"8.7","min":0},"subtitle":"创造完美的两性沟通","author":["盖瑞·查普曼"],"pubdate":"2006-1","tags":[{"count":1570,"name":"爱情","title":"爱情"},{"count":1463,"name":"心理学","title":"心理学"},{"count":1176,"name":"爱的五种语言","title":"爱的五种语言"},{"count":1010,"name":"婚姻","title":"婚姻"},{"count":853,"name":"交流，婚姻，人际关系","title":"交流，婚姻，人际关系"},{"count":632,"name":"人际关系","title":"人际关系"},{"count":628,"name":"爱","title":"爱"},{"count":540,"name":"心理","title":"心理"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s24492121.jpg","binding":"简裝本","translator":["王云良"],"catalog":"序一／1\n序二／3\n致谢辞／7\n第一章婚礼之后，爱情发生了什么变化?／1\n第二章保持爱箱常满／9\n第三章坠人情网／15\n第四章爱的语言之一：肯定的言词／27\n第五章爱的语言之二：精心的时刻／45\n第六章爱的语言之三：接受礼物／65\n第七章爱的语言之四：服务的行动／83\n第八章爱的语言之五：身体的接触／101\n第九章发现你的主要爱语／117\n第十章爱是一种选择／127\n第十一章爱使人生不再一样／137\n第十二章爱那不可爱的／145\n第十三章孩子们与爱的语言／159\n第十四章作者心语／171\n婚姻小组讨论研读指南／175","pages":"200","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s24492121.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s24492121.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s24492121.jpg"},"alt":"https://book.douban.com/subject/1444900/","id":"1444900","publisher":"中国轻工业出版社","isbn10":"7501950423","isbn13":"9787501950423","title":"爱的五种语言","url":"https://api.douban.com/v2/book/1444900","alt_title":"","author_intro":"","summary":"《爱的五种语言》值得婚前的恋爱男女阅读，更值得已婚的夫妻阅读，在离婚率高涨的今天，这本书实在是无价的。《爱的五种语言》持续50周出现在《出版者周刊》的畅销书排行榜上，被译成20种文字在全球发行，十年间销售突破了100万册。\n如果爱情是一则神话，那么这本书可以使美梦成真；如果爱情是一颗蜜糖，那么这本书将教你如何防潮防腐，让爱情进入婚姻永不褪色，永葆如新。\n\n要拥有一个不令你失望的婚姻吗？要一个真正能\u201c白头偕老、永浴爱河\u201d的婚姻吗？","price":"20.00元"},{"rating":{"max":10,"numRaters":332,"average":"9.3","min":0},"subtitle":"隐匿在计算机软硬件背后的语言","author":["查尔斯\u2022佩措尔德 (Charles Petzold)"],"pubdate":"2012-10-1","tags":[{"count":347,"name":"计算机","title":"计算机"},{"count":184,"name":"编程","title":"编程"},{"count":182,"name":"计算机原理","title":"计算机原理"},{"count":147,"name":"编码","title":"编码"},{"count":133,"name":"计算机科学","title":"计算机科学"},{"count":101,"name":"计算机科普","title":"计算机科普"},{"count":86,"name":"科普","title":"科普"},{"count":49,"name":"计算机组成原理","title":"计算机组成原理"}],"origin_title":"Code: The Hidden Language of Computer Hardware and Software","image":"https://img3.doubanio.com/view/subject/m/public/s25103742.jpg","binding":"平装","translator":["左飞","薛佟佟"],"catalog":"1至亲密友\n2编码与组合\n3布莱叶盲文与二进制码\n4手电筒的剖析\n5绕过拐角的通信\n6电报机与继电器\n7我们的十个数字\n8十的替代品\n9二进制数\n10逻辑与开关\n11门\n12二进制加法器\n13如何实现减法\n14反馈与触发器\n15字节与十六进制\n16存储器组织\n17自动操作\n18从算盘到芯片\n19两种典型的微处理器\n20ASCII码和字符转换\n21总线\n22操作系统\n23定点数和浮点数\n24高级语言与低级语言\n25图形化革命","pages":"420","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s25103742.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s25103742.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s25103742.jpg"},"alt":"https://book.douban.com/subject/20260928/","id":"20260928","publisher":"电子工业出版社","isbn10":"7121181185","isbn13":"9787121181184","title":"编码","url":"https://api.douban.com/v2/book/20260928","alt_title":"Code: The Hidden Language of Computer Hardware and Software","author_intro":"查尔斯·佩措尔德（Charles Petzold），是Windows编程界的一位大师，当今世界顶级技术作家。1994年5月，Petzold作为仅有的七个人之一（并且是唯一的作家）被《视窗杂志》和Microsoft公司联合授予Windows Pioneer奖，以表彰他对Microsoft Windows所做出的贡献。Petzold从1984年开始编写个人计算机程序，从1985年开始编写Microsoft Windows程序。1986年他在Microsoft Systems Journal的12月号上发表了第一篇关于Windows程序设计的论文。从1986年到l995年，Petzold为PC Magazine撰写专栏文章，向读者介绍Windows和OS／2程序设计等方面的知识。直到今天他依然保持着WindowsGDl程序设计首席技术作家的地位。其大作Programming Windows（Windows程序设计）是尽人皆知的Windows编程经典，曾深深地影Ⅱ向过一代程序员，该书目前已出至第5版。\n左飞，技术作家、译者，除本书外他还翻译了《代码阅读》和《代码质量》两部计算机领域的经典著作（两书分别荣获第14届和第17届美国Tolt图书震撼大奖），其所著的《代码揭秘》一书繁体版在中国台湾地区出版发行。2011年，在国家示范软件学院成立10周年庆祝大会上，他被国家示范软件学院院长联席会和大会组委会共同授予\u201c国家示范软件学院成立10周年全国十佳优秀毕业生\u201d称号，以表彰他在专业领域中所做出的突出成绩。\n薛佟佟，在南京航空航天大学取得工学硕士学位后加入中国移动通信集团，长期专注于云计算及分布式存储技术的研究与应用。他是中国移动公众服务云与一级私有云的核心推动者，同时是《提高C++性能的编程技术》（收录于电子工业出版社\u201c传世经典书丛\u201d）一书的译者。","summary":"编码：隐匿在计算机软硬件背后的语言，ISBN：9787121181184，作者：（美）佩措尔德（Petzold,C.）著 左飞，薛佟佟译","series":{"id":"6628","title":"传世经典书丛"},"price":"59.00元"},{"rating":{"max":10,"numRaters":493,"average":"9.2","min":0},"subtitle":"论语言、文学与非人道","author":["[美]乔治·斯坦纳"],"pubdate":"2013-11","tags":[{"count":421,"name":"乔治·斯坦纳","title":"乔治·斯坦纳"},{"count":418,"name":"文学理论","title":"文学理论"},{"count":189,"name":"文学","title":"文学"},{"count":171,"name":"语言与沉默","title":"语言与沉默"},{"count":152,"name":"文化研究","title":"文化研究"},{"count":148,"name":"文学史、文学批评及理论","title":"文学史、文学批评及理论"},{"count":128,"name":"美国","title":"美国"},{"count":111,"name":"文论","title":"文论"}],"origin_title":"Language and Silence","image":"https://img1.doubanio.com/view/subject/m/public/s27114547.jpg","binding":"平装","translator":["李小均"],"catalog":"序言\n人文素养\n人文素养\n逃离言词\n沉默与诗人\n教化我们的绅士\n夜语\u2014\u2014高雅色情文学与人的隐私\n毕达哥拉斯文体\u2014\u2014一份猜测，为纪念恩斯特\u2022 布洛赫而作\n走出黑暗的语言\n空洞的奇迹\n君特\u2022 格拉斯札记一则\nK\n勋伯格的《摩西与亚伦》\n一种幸存者\u2014\u2014献给埃利\u2022 维瑟尔（Elie Wiesel）\n后　记\n经典\n荷马与学者们\n《圣经》\n莎士比亚400 年\n两种翻译\n大师\n利维斯（F. R. LEAVIS）\n俄尔甫斯及其神话：列维\u2014斯特劳斯\n马歇尔\u2022 麦克卢汉\n小说与今日\n梅里美\n托马斯\u2022 曼的《菲利克斯\u2022 克鲁尔》\n劳伦斯\u2022 达雷尔与巴洛克小说\n建构一座丰碑\n\u201c死亡是一门艺术\u201d\n马克思主义与文学\n马克思主义与文学批评家\n乔治\u2022 卢卡奇与他的魔鬼契约\n美学宣言\n走出中欧\n作家与共产主义\n托洛茨基与悲剧想像力\n文学与以后的历史\u2014\u2014纪念乔治\u2022 卢卡奇\n译后记","ebook_url":"https://read.douban.com/ebook/22572595/","pages":"446","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s27114547.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s27114547.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s27114547.jpg"},"alt":"https://book.douban.com/subject/25751763/","id":"25751763","publisher":"世纪文景/上海人民出版社","isbn10":"7208113955","isbn13":"9787208113954","title":"语言与沉默","url":"https://api.douban.com/v2/book/25751763","alt_title":"Language and Silence","author_intro":"乔治·斯坦纳 George Steiner (1929 - )，美国著名文艺批评大师与翻译理论家，当代杰出的人文主义知识分子，熟谙英、法、德等数国语言与文化，执教于牛津、哈佛等著名高校。主要研究语言、文学与社会之间的关系及\u201c二战\u201d大屠杀的影响。美国文理学院荣誉会员，曾 获法国政府荣誉团骑士级奖章、阿方索·雷耶斯国际奖等多项殊荣。代表作有《语言与沉默》《悲剧之死》《巴别塔之后》等。\n译者 李小均，深圳大学外国语学院教授。著有《自由与反讽》、《信仰之海》，译有《薇拉》、《纳博科夫评传》、《苏格拉底与阿里斯托芬》、《梅尔维尔的政治哲学》、《在西方的目光下》、《在美国》、《古罗马的马车竞赛》、《碎心曲》、《尼采的使命》等。","summary":"◆当今文学世界最伟大的心灵，当代人文主义批评大师  乔治\u2022斯坦纳经典代表作\n◆最彻骨的现代启示录，最宏阔的人文主义襟怀\n本书的主题\u2014\u2014对政治暴行的深入反思\u2014\u2014极具当代性\n对文学的梳理兼具历史感与现实关怀\n可谓能指引我们重识自身与时代的经典作品\n◆著名学者李欧梵倾情作序推荐\n本书是乔治\u2022斯坦纳的代表作，也是20世纪西方人文批评的经典著作。其核心议题是语言、文学批评与人道主义（及反人道主义）。其辑录的文章写于不同时期，但都共有一个根本的主题\u2014\u2014语言的生命。在斯坦纳看来，语言是文化的代表。而现代西方的几股非人道主义逆流（尤其是纳粹）导致了语言文化的滥用与污染，使西方文学的创作陷入\u201c沉默\u201d。因此，在经历了种种浩劫之后，语言及其相关的现实世界究竟该何去何从？批评家与知识分子在这一过程中又该担当何种责任？","ebook_price":"25.00","series":{"id":"6589","title":"西方现代批评经典译丛"},"price":"49.00元"},{"rating":{"max":10,"numRaters":472,"average":"8.2","min":0},"subtitle":"谈笑间转变信念之NLP技巧","author":["罗伯特·迪尔茨"],"pubdate":"2008-10","tags":[{"count":684,"name":"心理学","title":"心理学"},{"count":604,"name":"NLP","title":"NLP"},{"count":545,"name":"沟通","title":"沟通"},{"count":422,"name":"语言","title":"语言"},{"count":226,"name":"思维","title":"思维"},{"count":177,"name":"心理","title":"心理"},{"count":140,"name":"自我管理","title":"自我管理"},{"count":92,"name":"方法","title":"方法"}],"origin_title":"Sleight of Mouth: The Magic of Conversational Belief Change","image":"https://img3.doubanio.com/view/subject/m/public/s3459605.jpg","binding":"平装","translator":["谭洪岗"],"catalog":"译者序\n献辞\n致谢\n前言\n第一章 语言与经验\n神奇的语言\n语言和身心语言程序学\n地图和实景\n经验(体验)\n语言如何框架体验\n第二章 框架和换框\n框架\n转移结果\n换框\n改变框架大小\n情境换框\n意义换框\n批评与批评者换框\n回应术模式之\u201c意图\u201d与\u201c重新定义\u201d\n一字换框法练习\n以\u201c第二人称\u201d的另一世界观看事情\n第三章 归类\n归类的形式\n向下分类\n向上归类\n横向归类(找出比喻)\n练习：找到相类\n标记和重新标记\n第四章 价值观与准则\n意义的结构\n价值观与动机\n准则和判断\n以重新定义来链接准则与价值观\n向下分类以界定\u201c标准等同\u201d\n现实检验策略\n现实检验策略练习\n向上归类以识别和应用价值观与准则层次\n准则层次技术\n第五章 信念和预期\n信念和信念系统\n信念的力量\n限制性信念\n预期\n预期与回应术模式之后果法\n描绘关键信念和预期\n评估改变的动机\n信念评估单\n用\u201c就像\u201d框架强化信念和预期\n\u201c就像\u201d练习\n第六章 信念的基本结构\n信念的语言结构\n因果\n回应术与信念结构\n价值观审视\n价值观审视工作表\n信念审视\n用反例重新评估限制性信念\n引起限制性信念陈述的言语框架\n产生反例\n第七章 内在状态与自然发生的信念改变\n信念改变的自然过程\n信念改变循环\n信念改变与内在状态\n练习：启动和锚定一个状态\n指导和内在指导者\n信念改变循坏的程序\n信念链接\n非言语沟通的影响\n第八章 思想病毒与信念的后设结构\n信念的后设结构\n思想病毒\n前提假设\n自我参考\n逻辑类型理论\n对信念或归纳总结反击其身\n超越框架\n逻辑层次\n改变逻辑层次\n第九章 系统应用各种模式\n回应术模式的定义和举例\n回应术模式作为言语干预的一个系统\n将回应术用做系统模式\n用回应术创立和维持\u201c思想病毒\u201d\n回应术与必需的多样性法则\n用回应术换框和\u201c破框\u201d思想病毒\n练习回应术\n第十章 结论\n结论\n后记\n参考文献","pages":"260","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s3459605.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s3459605.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s3459605.jpg"},"alt":"https://book.douban.com/subject/3248660/","id":"3248660","publisher":"世界图书出版公司","isbn10":"7506291363","isbn13":"9787506291361","title":"语言的魔力","url":"https://api.douban.com/v2/book/3248660","alt_title":"Sleight of Mouth: The Magic of Conversational Belief Change","author_intro":"罗伯特·迪尔茨(Robert Dilts)，国际顶级NLP大师，被公认为现今对NLP贡献最多的人。自1975年以来作为NLP的开发者、作者、培训师和顾问，除了率先把NLP应用于组织发展、教育、创造力开发、保健、领导力培养之外，还整理和开发了系统NLP、理解层次、重塑印记法、矛盾整合、消除过敏等许多著名的NLP技巧。他对NLP领域的贡献还包括策略和信念系统NLP技术的前期工作。NLP作为改变人类思维方式的工具，正被越来越多的人应用于生活和工作。\n谭洪岗，心理顾问，心理剧助理导演。原籍湖南，现居北京。中国科技大学理学士；北京大学心理学硕士。接受心理剧、家庭治疗、系统排列、催眠等训练千余小时。现以系统观点、人本基调、整合方法、资源取向，从事心理咨询与心灵成长类培训。有译作《真相一治疗心灵的妙方》(香港蓝天图书，2008年出版)，合译《艾瑞克森催眠治疗理论》等。","summary":"从如何与别人交谈到确定自己的生活道路；从简单的句式转换到各种回应术模式的综合运用，《语言的魔力》在不知不觉间转变了我们的信念，教会了我们一种全新的世界观\u2014\u2014这就是回应术的神奇之处。或许《语言的魔力》教会你的远不止这些。一个积极的人生态度；一种快乐、健康的心理状态，体现在我们日常生活的点点滴滴中。","price":"35.00元"},{"rating":{"max":10,"numRaters":176,"average":"9.4","min":0},"subtitle":"","author":["K. N. King"],"pubdate":"2007-11","tags":[{"count":361,"name":"C语言","title":"C语言"},{"count":137,"name":"C","title":"C"},{"count":136,"name":"编程","title":"编程"},{"count":108,"name":"程序设计","title":"程序设计"},{"count":98,"name":"计算机","title":"计算机"},{"count":70,"name":"编程语言","title":"编程语言"},{"count":62,"name":"软件开发","title":"软件开发"},{"count":58,"name":"Programming","title":"Programming"}],"origin_title":"","image":"https://img1.doubanio.com/view/subject/m/public/s2843317.jpg","binding":"","translator":[],"catalog":"","pages":"408","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s2843317.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s2843317.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s2843317.jpg"},"alt":"https://book.douban.com/subject/2280547/","id":"2280547","publisher":"人民邮电出版社","isbn10":"7115167079","isbn13":"9787115167071","title":"C语言程序设计现代方法","url":"https://api.douban.com/v2/book/2280547","alt_title":"","author_intro":"","summary":"《C语言程序设计现代方法》最主要的一个目的就是通过一种\u201c现代方法\u201d来介绍C语言，实现客观评价C语言、强调标准化C语言、强调软件工程、不再强调\u201c手工优化\u201d、强调与c++语言的兼容性的目标。《C语言程序设计现代方法》分为C语言的基础特性。C语言的高级特性、C语言标准库和参考资料4个部分。每章都有\u201c问与答\u201d小节，给出一系列与本章内容相关的问题及其答案，此外还包含适量的习题。","series":{"id":"18507","title":"图灵计算机科学丛书"},"price":"55.00元"},{"rating":{"max":10,"numRaters":1201,"average":"8.9","min":0},"subtitle":"C语言调试指南","author":["凯尼格"],"pubdate":"2008-2-1","tags":[{"count":667,"name":"C语言","title":"C语言"},{"count":408,"name":"编程","title":"编程"},{"count":274,"name":"C","title":"C"},{"count":241,"name":"c","title":"c"},{"count":239,"name":"计算机","title":"计算机"},{"count":188,"name":"C/C++","title":"C/C++"},{"count":176,"name":"经典","title":"经典"},{"count":170,"name":"程序设计","title":"程序设计"}],"origin_title":"C Traps and Pitfalls","image":"https://img3.doubanio.com/view/subject/m/public/s2870233.jpg","binding":"平装","translator":["高巍"],"catalog":"第0章　导读\n第1章　词法\u201c陷阱\u201d\n1.1　=不同于==\n1.2　& 和 | 不同于&& 和 ||\n1.3　词法分析中的\u201c贪心法\u201d\n1.4　整型常量\n1.5　字符与字符串\n第2章　语法\u201c陷阱\u201d\n2.1　理解函数声明\n2.2　运算符的优先级问题\n2.3　注意作为语句结束标志的分号\n2.4　switch语句\n2.5　函数调用\n2.6　\u201c悬挂\u201delse引发的问题\n第3章　语义\u201c陷阱\u201d\n3.1　指针与数组\n3.2　非数组的指针\n3.3　作为参数的数组声明\n3.4　避免\u201c举隅法\u201d\n3.5　空指针并非空字符串\n3.6　边界计算与不对称边界\n3.7　求值顺序\n3.8　运算符&&、|| 和 !\n3.9　整数溢出\n3.10　为函数main提供返回值\n第4章　连接\n4.1　什么是连接器\n4.2　声明与定义\n4.3　命名冲突与static修饰符\n4.4　形参、实参与返回值\n4.5　检查外部类型\n4.6　头文件\n第5章　库函数\n5.1　返回整数的getchar函数\n5.2　更新顺序文件\n5.3　缓冲输出与内存分配\n5.4　使用errno检测错误\n5.5　库函数signal\n第6章　预处理器\n6.1　不能忽视宏定义中的空格\n6.2　宏并不是函数\n6.3　宏并不是语句\n6.4　宏并不是类型定义\n第7章　可移植性缺陷\n7.1　应对C语言标准变更\n7.2　标识符名称的限制\n7.3　整数的大小\n7.4　字符是有符号整数还是无符号整数\n7.5　移位运算符\n7.6　内存位置0\n7.7　除法运算时发生的截断\n7.8　随机数的大小\n7.9　大小写转换\n7.10　首先释放，然后重新分配\n7.11　可移植性问题的一个例子\n第8章　建议与答案\n8.1　建议\n8.2　答案\n附录A　PRINTF，VARARGS与STDARG\n附录B　Koenig和Moo夫妇访谈","pages":"172","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s2870233.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s2870233.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s2870233.jpg"},"alt":"https://book.douban.com/subject/2778632/","id":"2778632","publisher":"人民邮电出版社","isbn10":"7115171793","isbn13":"9787115171795","title":"C陷阱与缺陷","url":"https://api.douban.com/v2/book/2778632","alt_title":"C Traps and Pitfalls","author_intro":"Andrew Koenig 是AT&T公司Shannon实验室大规模编程研究部门中的成员，同时也是C++标准委员会的项目编辑。他的编程经验超过30年，其中有15年在使用C++，他已经出版了超过150 篇和C++有关的论文，并且在世界范围内就这个主题进行过多次演讲。","summary":"作者以自己1985年在Bell实验室时发表的一篇论文为基础，结合自己的工作经验扩展成为这本对C程序员具有珍贵价值的经典著作。写作本书的出发点不是要批判C语言，而是要帮助C程序员绕过编程过程中的陷阱和障碍。..\n全书分为8章，分别从词法分析、语法语义、连接、库函数、预处理器、可移植性缺陷等几个方面分析了C编程中可能遇到的问题。最后，作者用一章的篇幅给出了若干具有实用价值的建议。..\n本书适合有一定经验的C程序员阅读学习，即便你是C编程高手，本书也应该成为你的案头必备书籍。","series":{"id":"9931","title":"C和C++经典著作"},"price":"30.00元"},{"rating":{"max":10,"numRaters":1634,"average":"9.1","min":0},"subtitle":"","author":["Douglas Crockford"],"pubdate":"2009-4","tags":[{"count":2073,"name":"JavaScript","title":"JavaScript"},{"count":794,"name":"Web前端开发","title":"Web前端开发"},{"count":335,"name":"编程","title":"编程"},{"count":300,"name":"web开发","title":"web开发"},{"count":275,"name":"javacript","title":"javacript"},{"count":261,"name":"计算机","title":"计算机"},{"count":244,"name":"O'Reilly","title":"O'Reilly"},{"count":210,"name":"web","title":"web"}],"origin_title":"JavaScript:The Good Parts","image":"https://img3.doubanio.com/view/subject/m/public/s3651235.jpg","binding":"平装","translator":["赵泽欣","鄢学鹍"],"catalog":"前言\tI\n第1章 精华\t1\n为什么是JAVASCRIPT?\t2\n分析JAVASCRIPT\t3\n一个简单的试验场\t4\n第2章 语法\t5\n空白\t5\n标识符\t6\n数字\t7\n字符串\t8\n语句\t10\n表达式\t15\n字面量\t17\n函数\t19\n第3章 对象\t20\n对象字面量\t20\n检索\t21\n更新\t22\n引用\t22\n原型\t22\n反射\t23\n枚举\t24\n删除\t24\n减少全局变量污染\t25\n第4章 函数\t26\n函数对象\t26\n函数字面量\t27\n调用\t27\n参数\t31\n返回\t31\n异常\t32\n给类型增加方法\t32\n递归\t34\n作用域\t36\n闭包\t37\n回调\t40\n模块\t40\n级联\t42\n套用\t43\n记忆\t44\n第5章 继承..\t46\n伪类\t47\n对象说明符\t50\n原型\t50\n函数化\t52\n部件\t55\n第6章 数组\t58\n数组字面量\t58\n长度\t59\n删除\t60\n枚举\t60\n混淆的地方\t61\n方法\t62\n维度\t63\n第7章 正则表达式\t65\n一个例子\t66\n结构\t70\n元素\t72\n第8章 方法\t78\n第9章 代码风格\t94\n第10章 优美的特性\t98\n附录A：糟粕\t101\n附录B：鸡肋\t109\n附录C：JSLINT\t115\n附录D：语法图\t125\n附录E：JSON\t136\n索引\t147","pages":"155","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s3651235.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s3651235.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s3651235.jpg"},"alt":"https://book.douban.com/subject/3590768/","id":"3590768","publisher":"电子工业出版社","isbn10":"7121084376","isbn13":"9787121084379","title":"JavaScript语言精粹","url":"https://api.douban.com/v2/book/3590768","alt_title":"JavaScript:The Good Parts","author_intro":"Douglas Crockford是一名来自Yahoo!的资深JavaScript架构师，以创造和维护JSON (JavaScriptObject Notation) 格式而为大家所熟知。他定期在各类会议上发表有关高级JavaScript的主题演讲。","summary":"本书通过对JavaScript语言的分析，甄别出好的和坏的特性，从而提取出相对这门语言的整体而言具有更好的可靠性、可读性和可维护性的JavaScript的子集，以便你能用它创建真正可扩展的和高效的代码。\n雅虎资深JavaScript架构师Douglas Crockford倾力之作。\n向读者介绍如何运用JavaScript创建真正可扩展的和高效的代码。","series":{"id":"697","title":"O'reilly系列"},"price":"35.00元"},{"rating":{"max":10,"numRaters":6416,"average":"9.3","min":0},"subtitle":"","author":["中国社会科学院语言研究所词典编辑室 编"],"pubdate":"1996-7","tags":[{"count":1328,"name":"工具书","title":"工具书"},{"count":482,"name":"现代汉语词典","title":"现代汉语词典"},{"count":405,"name":"词典","title":"词典"},{"count":244,"name":"汉语","title":"汉语"},{"count":217,"name":"中国","title":"中国"},{"count":166,"name":"语言","title":"语言"},{"count":148,"name":"字典","title":"字典"},{"count":92,"name":"我有的书","title":"我有的书"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s1148324.jpg","binding":"精装","translator":[],"catalog":"凡例\r\n音节表\r\n新旧字形对照表\r\n部首检字表\r\n词典正文(附西文字母开头的词语)\r\n附录\r\n   我国历代纪元表\r\n   计量单位表\r\n   汉字偏旁名称表\r\n   汉语拼音方案\r\n   元素周期表","pages":"1722","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s1148324.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1148324.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1148324.jpg"},"alt":"https://book.douban.com/subject/1036684/","id":"1036684","publisher":"商务印书馆","isbn10":"7100017777","isbn13":"9787100017770","title":"现代汉语词典（修订本）","url":"https://api.douban.com/v2/book/1036684","alt_title":"","author_intro":"","summary":"这是一部以记录普通话语汇为主的中型词典，供中等以上文化程度的读者使用。词典中所收条目，包括字、词、词组、熟语、成语等，共约五万六千余条。 此外，还收了一些用于地名、人名、姓氏等方面的字和少数现代不很常用的字。这些条目大都在注释中分别交代了，或者附加标记，以便识别。","price":"55.00元"},{"rating":{"max":10,"numRaters":358,"average":"9.0","min":0},"subtitle":"","author":["塞缪尔·早川 Samuel Hayakawa","艾伦·早川 Alan Hayakawa"],"pubdate":"2015-7","tags":[{"count":388,"name":"语言学","title":"语言学"},{"count":140,"name":"语义学","title":"语义学"},{"count":134,"name":"语言","title":"语言"},{"count":125,"name":"思维","title":"思维"},{"count":108,"name":"认知","title":"认知"},{"count":90,"name":"文化","title":"文化"},{"count":80,"name":"社会","title":"社会"},{"count":67,"name":"語言學","title":"語言學"}],"origin_title":"Language in Thought and Action","image":"https://img3.doubanio.com/view/subject/m/public/s28367610.jpg","binding":"精装","translator":["柳之元"],"catalog":"第一编  语言的功用\n第一章  语言与生存\n第二章  符号\n第三章  报告用的语言\n第四章  前后文\n第五章  有助于社会团结的语言\n第六章  语言的双重任务\n第七章  控制社会的语言\n第八章  传达感情的语言\n第九章  艺术和激荡的情绪\n第二编  语言和思想\n第十章  我们是怎样得到知识的\n第十一章  捕风捉影\n第十二章  分类\n第十三章  二元价值观点与多元价值观点\n第十四章  一团糟\n第十五章  老鼠和人\n第十六章  走向内心和外界的秩序","pages":"299","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s28367610.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s28367610.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s28367610.jpg"},"alt":"https://book.douban.com/subject/26431646/","id":"26431646","publisher":"北京大学出版社","isbn10":"7301259700","isbn13":"9787301259702","title":"语言学的邀请","url":"https://api.douban.com/v2/book/26431646","alt_title":"Language in Thought and Action","author_intro":"塞缪尔·早川（Samuel Hayakawa, 1906-1992），日裔美籍语言学家、心理学家、作家、政治家；旧金山州立大学英语教授，1968年任代理校长；1977-1983年间任美国参议员。本书为其代表作。\n艾伦·早川（Alan Hayakawa），1974-1989年为报社记者，1992-2008年为网站编辑，现为自由撰稿人。","summary":"编者序\n本书原名Language in Thought and Action，它所讨论的问题属于语义学范畴。语义学是一门新兴学科，在我们中国，不但知道这是一门什么学问的人很少，甚至很多人连这门学科的名字都不曾听过。照常理来说，我们一定会觉得，这样一门冷僻而陌生的学问与我们一定是格格不入。可是，这本书却绝对是个例外，读起来津津有味，一点儿也不枯燥。这固然要归功于作者\u201c深入浅出\u201d的写作技巧，同时我们也要感谢译者的译笔灵活通达。在改用中国古诗词代替原书例句这一点上，译者更是功不可没。\n虽然我们对这门学问很陌生，可是书中讨论的问题却是我们时时刻刻都会碰到的问题。作者写这本书的主要目的是想告诉人们\u201c怎样说话、怎样听话\u201d，话说对了有什么好处，话说错了有什么不好、会惹出什么祸，把话说好是如何重要；也许有人会对此感到惊讶；我们既能读又能写，还要学说话吗？我们一出生就牙牙学语，学到如今还不够吗？谁不会说话，还学它干吗？还要读者本书？且慢，恐怕最需要读这本书的人便是那些自以为早已会说话的人。你究竟会不会听话呢？会不会说话呢？恐怕得看完这本书才能有一个比较可靠的答复。\n这本书所说的\u201c话说\u201d或\u201c语言\u201d也包括\u201c文字\u201d在内。第八、九章实则是在告诉我们怎样协作。对爱好写作的读者朋友来说，本书无疑具有更大的意义。","series":{"id":"34073","title":"大学的邀请"},"price":"48.00元"},{"rating":{"max":10,"numRaters":527,"average":"8.6","min":0},"subtitle":"","author":["[乌]丹尼艾尔·阿里洪（Daniel Arijon）"],"pubdate":"2013-2","tags":[{"count":1047,"name":"电影","title":"电影"},{"count":797,"name":"电影理论","title":"电影理论"},{"count":299,"name":"艺术","title":"艺术"},{"count":268,"name":"影视艺术","title":"影视艺术"},{"count":138,"name":"艺术-电影","title":"艺术-电影"},{"count":131,"name":"电影学院","title":"电影学院"},{"count":128,"name":"后浪","title":"后浪"},{"count":74,"name":"剪辑","title":"剪辑"}],"origin_title":"GRAMMAR OF THE FILM LANGUAGE","image":"https://img1.doubanio.com/view/subject/m/public/s24612667.jpg","binding":"平装","translator":["陈国铎","黎锡","周传基 审校"],"catalog":"出版前言\n推荐序\n原编者的话\n序言\n第一章\t作为一种视觉交流系统的电影语言\n第二章\t电影平行剪辑的重要性\n第三章\t基本手段的定义\n第四章\t三角形原理\n第五章\t两个演员的对话\n第六章\t三个演员的对话\n第七章\t四人或更多人的对话场面\n第八章\t静态对话场面的剪辑形式\n第九章\t画面动作的特性\n第十章\t运动结束后的剪接\n第十一章\t画面内的运动\n第十二章\t入画和出画的动作\n第十三章 演员A走向演员B\n第十四章 用主镜头拍摄画面中的动作\n第十五章 不规则的例子\n第十六章 演员A离开演员B\n第十七章 演员们一起运动\n第十八章 困难的剪辑情况的解决\n第十九章 其他类型运动\n第二十章 运动镜头的二十条基本规律\n第二十一章 摇摄镜头\n第二十二章 移动摄影\n第二十三章 摄影升降机和变焦距镜头\n第二十四章 动作性场面\n第二十五章 镜头内的组接\n第二十六章 由一个表演区到另一个表演区\n第二十七章 组合的技巧\n第二十八章 电影的分句法\n结束语","pages":"350","images":{"small":"https://img1.doubanio.com/view/subject/s/public/s24612667.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s24612667.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s24612667.jpg"},"alt":"https://book.douban.com/subject/20516061/","id":"20516061","publisher":"北京联合出版公司·后浪出版公司","isbn10":"7550211833","isbn13":"9787550211834","title":"电影语言的语法","url":"https://api.douban.com/v2/book/20516061","alt_title":"GRAMMAR OF THE FILM LANGUAGE","author_intro":"丹尼艾尔·阿里洪（Daniel Arijon），乌拉圭电影剪辑师、编剧和导演。自1959年投身专业电影制作以来，他先后在乌拉圭、阿根廷、巴西和智利拍摄过多部新闻片、广告片、纪录片和故事片，也教授过电影课程，并在杂志上发表过若干专业文章。\n译者：周传基，资深电影人、教授。1950年于山东大学文学院外国文学系毕业，获英国文学学士学位。中国电影家协会会员、中国电影音乐学会理事、中国电影剪辑学会理事、中国电影评论家学会会员。他是著名导演张艺谋、陈凯歌的老师，先后为无锡国际旅游电影节、夏威夷国际电影节担任评委，1995 年为美国旧金山大学讲授电影公共课，是中国著名的电影教育家。已出版专著《电影·电视·广播中的声音》、《影片读解》，译著《旧好莱坞/新好莱坞：仪式、艺术与工业》、《电影实践理论》、《电影导演工作》等。\n组织者：孙明经，祖籍山东，生于南京。中国电影教育家，我国高校电影学科奠基人之一，联合国教科文中国委员。1934年毕业于南京金陵大学物理系，1934-1952年任教于金陵大学影音部。拍摄过50余部教育电影。1942年创办《电影与播音》杂志并担任主编。1952年院系调整来京参加电影学院摄影系的创建。编写七部电影摄影教材。一生从事电影教育。","summary":"★ 全球畅销三十余年并被翻译成数十种语言，被公认为讨论导演、摄影、剪辑等电影影像画面组织技巧方面最详密、实用的经典之作\n★ 从实践出发阐明摄影机位、场面调度、剪辑等电影语言，为\u201c用画面讲故事\u201d奠定基础\n★ 百科全书式的工作手册，囊括拍摄中的所有基本设计方案，如对话场面、人物运动，使初学者能够迅速掌握专业方法\n★ 近500幅机位图、故事板贯穿全书，帮助读者一目了然地理解电影语言\n★ 对大量经典影片的典型段落进行多角度分析，如《西北偏北》、《放大》、《广岛之恋》、《桂河大桥》，深入揭示其中激动人心的奥秘\n★ 本书是中国老一辈电影教育工作者精心挑选的教材，在翻译、审订中投入了巨大的心力，译笔简明、准确、流畅，惠及无数电影人\n本书是乌拉圭电影导演丹尼艾尔·阿里洪根据本人创作实践经验编写的电影叙事技巧教程，其专业性、实用性、经典性为全球各影视院校所公认。作者不对电影的拍摄工作做过多理论论述，而是集中从实践经验入手，对制作过程中出现的种种问题加以细致精准的研究探讨，并提出行之有效的解决方案。全书涉及到电影制作中如摄影机位、场面调度、剪辑等关键问题，对两个以上演员对话场面的处理、摄影机位三角形原理的运用、内外反拍等也均有详细论述。全书层次分明，清晰准确，并有近500幅插图贯穿其中，便于读者充分理解和掌握。\n本书译者多为中国老一辈电影教育工作者，如周传基、吕锦瑷、李溪桥、裴未如等，译稿准确流畅，影响深远，被北京电影学院列为必读书目，更有人盛誉此书\u201c开启了中国电影新的时代\u201d。","series":{"id":"24802","title":"后浪电影学院"},"price":"49.80元"},{"rating":{"max":10,"numRaters":601,"average":"8.8","min":0},"subtitle":"","author":["卡巴科弗 (Robert I.Kabacoff)"],"pubdate":"2013-1","tags":[{"count":933,"name":"数据分析","title":"数据分析"},{"count":816,"name":"R","title":"R"},{"count":445,"name":"数据挖掘","title":"数据挖掘"},{"count":335,"name":"统计","title":"统计"},{"count":192,"name":"编程","title":"编程"},{"count":188,"name":"R语言","title":"R语言"},{"count":156,"name":"计算机","title":"计算机"},{"count":146,"name":"数据可视化","title":"数据可视化"}],"origin_title":"R in Action","image":"https://img3.doubanio.com/view/subject/m/public/s24576400.jpg","binding":"平装","translator":["高涛","肖楠","陈钢"],"catalog":"目 　 　录\n第一部分 　入 　 　门\n第1章 　R语言介绍　　3\n1.1 　为何要使用R？　　4\n1.2 　R的获取和安装　　6\n1.3 　R的使用　　7\n1.3.1 　新手上路　　7\n1.3.2 　获取帮助　　10\n1.3.3 　工作空间　　10\n1.3.4 　输入和输出　　12\n1.4 　包　　14\n1.4.1 　什么是包　　14\n1.4.2 　包的安装　　14\n1.4.3 　包的载入　　14\n1.4.4 　包的使用方法　　15\n1.5 　批处理　　15\n1.6 　将输出用为输入\u2014\u2014结果的重用　　16\n1.7 　处理大数据集　　16\n1.8 　示例实践　　17\n1.9 　小结　　18\n第2章 　创建数据集　　19\n2.1 　数据集的概念　　19\n2.2 　数据结构　　20\n2.2.1 　向量　　21\n2.2.2 　矩阵　　22\n2.2.3 　数组　　23\n2.2.4 　数据框　　24\n2.2.5 　因子　　27\n2.2.6 　列表　　29\n2.3 　数据的输入　　30\n2.3.1 　使用键盘输入数据　　31\n2.3.2 　从带分隔符的文本文件导入数据　　32\n2.3.3 　导入Excel数据　　33\n2.3.4 　导入XML数据　　34\n2.3.5 　从网页抓取数据　　34\n2.3.6 　导入SPSS数据　　34\n2.3.7 　导入SAS数据　　34\n2.3.8 　导入Stata数据　　35\n2.3.9 　导入netCDF数据　　35\n2.3.10 　导入HDF5数据　　35\n2.3.11 　访问数据库管理系统　　36\n2.3.12 　通过Stat/Transfer导入数据　　37\n2.4 　数据集的标注　　37\n2.4.1 　变量标签　　38\n2.4.2 　值标签　　38\n2.5 　处理数据对象的实用函数　　38\n2.6 　小结　　39\n第3章 　图形初阶　　40\n3.1 　使用图形　　40\n3.2 　一个简单的例子　　42\n3.3 　图形参数　　43\n3.3.1 　符号和线条　　45\n3.3.2 　颜色　　46\n3.3.3 　文本属性　　47\n3.3.4 　图形尺寸与边界尺寸　　49\n3.4 　添加文本、自定义坐标轴和图例　　50\n3.4.1 　标题　　51\n3.4.2 　坐标轴　　52\n3.4.3 　参考线　　54\n3.4.4 　图例　　54\n3.4.5 　文本标注　　56\n3.5 　图形的组合　　58\n3.6 　小结　　64\n第4章 　基本数据管理　　65\n4.1 　一个示例　　65\n4.2 　创建新变量　　67\n4.3 　变量的重编码　　68\n4.4 　变量的重命名　　69\n4.5 　缺失值　　70\n4.5.1 　重编码某些值为缺失值　　71\n4.5.2 　在分析中排除缺失值　　72\n4.6 　日期值　　73\n4.6.1 　将日期转换为字符型变量　　74\n4.6.2 　更进一步　　74\n4.7 　类型转换　　74\n4.8 　数据排序　　75\n4.9 　数据集的合并　　76\n4.9.1 　添加列　　76\n4.9.2 　添加行　　76\n4.10 　数据集取子集　　77\n4.10.1 　选入（保留）变量　　77\n4.10.2 　剔除（丢弃）变量　　77\n4.10.3 　选入观测　　78\n4.10.4 　subset()函数　　79\n4.10.5 　随机抽样　　79\n4.11 　使用SQL语句操作数据框　　80\n4.12 　小结　　81\n第5章 　高级数据管理　　82\n5.1 　一个数据处理难题　　82\n5.2 　数值和字符处理函数　　83\n5.2.1 　数学函数　　83\n5.2.2 　统计函数　　84\n5.2.3 　概率函数　　86\n5.2.4 　字符处理函数　　89\n5.2.5 　其他实用函数　　90\n5.2.6 　将函数应用于矩阵和数据框　　91\n5.3 　数据处理难题的一套解决方案　　93\n5.4 　控制流　　96\n5.4.1 　重复和循环　　97\n5.4.2 　条件执行　　97\n5.5 　用户自编函数　　99\n5.6 　整合与重构　　101\n5.6.1 　转置　　101\n5.6.2 　整合数据　　101\n5.6.3 　reshape包　　102\n5.7 　小结　　105\n第二部分 　基本方法\n第6章 　基本图形　　108\n6.1 　条形图　　108\n6.1.1 　简单的条形图　　109\n6.1.2 　堆砌条形图和分组条形图　　110\n6.1.3 　均值条形图　　111\n6.1.4 　条形图的微调　　112\n6.1.5 　棘状图　　113\n6.2 　饼图　　114\n6.3 　直方图　　116\n6.4 　核密度图　　118\n6.5 　箱线图　　120\n6.5.1 　使用并列箱线图进行跨组比较　　121\n6.5.2 　小提琴图　　124\n6.6 　点图　　125\n6.7 　小结　　128\n第7章 　基本统计分析　　129\n7.1 　描述性统计分析　　130\n7.1.1 　方法云集　　130\n7.1.2 　分组计算描述性统计量　　133\n7.1.3 　结果的可视化　　136\n7.2 　频数表和列联表　　136\n7.2.1 　生成频数表　　137\n7.2.2 　独立性检验　　142\n7.2.3 　相关性的度量　　144\n7.2.4 　结果的可视化　　144\n7.2.5 　将表转换为扁平格式　　144\n7.3 　相关　　146\n7.3.1 　相关的类型　　146\n7.3.2 　相关性的显著性检验　　148\n7.3.3 　相关关系的可视化　　150\n7.4 　t检验　　150\n7.4.1 　独立样本的t检验　　150\n7.4.2 　非独立样本的t检验　　151\n7.4.3 　多于两组的情况　　152\n7.5 　组间差异的非参数检验　　152\n7.5.1 　两组的比较　　152\n7.5.2 　多于两组的比较　　153\n7.6 　组间差异的可视化　　155\n7.7 　小结　　155\n第三部分 　中级方法\n第8章 　回归　　158\n8.1 　回归的多面性　　159\n8.1.1 　OLS回归的适用情境　　159\n8.1.2 　基础回顾　　160\n8.2 　OLS回归　　160\n8.2.1 　用lm()拟合回归模型　　161\n8.2.2 　简单线性回归　　162\n8.2.3 　多项式回归　　164\n8.2.4 　多元线性回归　　167\n8.2.5 　有交互项的多元线性回归　　169\n8.3 　回归诊断　　171\n8.3.1 　标准方法　　171\n8.3.2 　改进的方法　　175\n8.3.3 　线性模型假设的综合验证　　180\n8.3.4 　多重共线性　　181\n8.4 　异常观测值　　181\n8.4.1 　离群点　　182\n8.4.2 　高杠杆值点　　182\n8.4.3 　强影响点　　183\n8.5 　改进措施　　186\n8.5.1 　删除观测点　　186\n8.5.2 　变量变换　　186\n8.5.3 　增删变量　　187\n8.5.4 　尝试其他方法　　188\n8.6 　选择\u201c最佳\u201d的回归模型　　188\n8.6.1 　模型比较　　188\n8.6.2 　变量选择　　189\n8.7 　深层次分析　　193\n8.7.1 　交叉验证　　193\n8.7.2 　相对重要性　　194\n8.8 　小结　　197\n第9章 　方差分析　　198\n9.1 　术语速成　　198\n9.2 　ANOVA模型拟合　　201\n9.2.1 　aov()函数　　201\n9.2.2 　表达式中各项的顺序　　201\n9.3 　单因素方差分析　　202\n9.3.1 　多重比较　　204\n9.3.2 　评估检验的假设条件　　206\n9.4 　单因素协方差分析　　208\n9.4.1 　评估检验的假设条件　　209\n9.4.2 　结果可视化　　210\n9.5 　双因素方差分析　　211\n9.6 　重复测量方差分析　　214\n9.7 　多元方差分析　　216\n9.7.1 　评估假设检验　　217\n9.7.2 　稳健多元方差分析　　219\n9.8 　用回归来做ANOVA　　219\n9.9 　小结　　221\n第10章 　功效分析　　222\n10.1 　假设检验速览　　222\n10.2 　用pwr包做功效分析　　225\n10.2.1 　t检验　　225\n10.2.2 　方差分析　　227\n10.2.3 　相关性　　227\n10.2.4 　线性模型　　228\n10.2.5 　比例检验　　229\n10.2.6 　卡方检验　　229\n10.2.7 　在新情况中选择合适的效应值　　230\n10.3 　绘制功效分析图形　　232\n10.4 　其他软件包　　234\n10.5 　小结　　235\n第11章 　中级绘图　　236\n11.1 　散点图　　237\n11.1.1 　散点图矩阵　　239\n11.1.2 　高密度散点图　　244\n11.1.3 　三维散点图　　247\n11.1.4 　气泡图　　250\n11.2 　折线图　　252\n11.3 　相关图　　255\n11.4 　马赛克图　　259\n11.5 　小结　　261\n第12章 　重抽样与自助法　　263\n12.1 　置换检验　　263\n12.2 　用coin包做置换检验　　265\n12.2.1 　独立两样本和K样本检验　　266\n12.2.2 　列联表中的独立性　　267\n12.2.3 　数值变量间的独立性　　268\n12.2.4 　两样本和K样本相关性检验　　268\n12.2.5 　深入探究　　269\n12.3 　lmPerm包的置换检验　　269\n12.3.1 　简单回归和多项式回归　　269\n12.3.2 　多元回归　　271\n12.3.3 　单因素方差分析和协方差分析　　271\n12.3.4 　双因素方差分析　　272\n12.4 　置换检验点评　　273\n12.5 　自助法　　273\n12.6 　boot包中的自助法　　274\n12.6.1 　对单个统计量使用自助法　　275\n12.6.2 　多个统计量的自助法　　277\n12.7 　小结　　279\n第四部分 　高级方法\n第13章 　广义线性模型　　282\n13.1 　广义线性模型和glm()函数　　282\n13.1.1 　glm()函数　　283\n13.1.2 　连用的函数　　284\n13.1.3 　模型拟合和回归诊断　　285\n13.2 　Logistic回归　　285\n13.2.1 　解释模型参数　　288\n13.2.2 　评价预测变量对结果概率的影响　　289\n13.2.3 　过度离势　　290\n13.2.4 　扩展　　291\n13.3 　泊松回归　　291\n13.3.1 　解释模型参数　　293\n13.3.2 　过度离势　　294\n13.3.3 　扩展　　295\n13.4 　小结　　297\n第14章 　主成分和因子分析　　298\n14.1 　R中的主成分和因子分析　　299\n14.2 　主成分分析　　300\n14.2.1 　判断主成分的个数　　300\n14.2.2 　提取主成分　　302\n14.2.3 　主成分旋转　　305\n14.2.4 　获取主成分得分　　306\n14.3 　探索性因子分析　　307\n14.3.1 　判断需提取的公共因子数　　308\n14.3.2 　提取公共因子　　309\n14.3.3 　因子旋转　　310\n14.3.4 　因子得分　　313\n14.3.5 　其他与EFA相关的包　　313\n14.4 　其他潜变量模型　　314\n14.5 　小结　　314\n第15章 　处理缺失数据的高级方法　　316\n15.1 　处理缺失值的步骤　　317\n15.2 　识别缺失值　　318\n15.3 　探索缺失值模式　　319\n15.3.1 　列表显示缺失值　　319\n15.3.2 　图形探究缺失数据　　320\n15.3.3 　用相关性探索缺失值　　322\n15.4 　理解缺失数据的来由和影响　　324\n15.5 　理性处理不完整数据　　325\n15.6 　完整实例分析（行删除）　　326\n15.7 　多重插补　　327\n15.8 　处理缺失值的其他方法　　331\n15.8.1 　成对删除　　331\n15.8.2 　简单（非随机）插补　　332\n15.9 　小结　　332\n第16章 　高级图形进阶　　333\n16.1 　R中的四种图形系统　　333\n16.2 　lattice包　　334\n16.2.1 　条件变量　　338\n16.2.2 　面板函数　　339\n16.2.3 　分组变量　　342\n16.2.4 　图形参数　　345\n16.2.5 　页面摆放　　346\n16.3 　ggplot2包　　347\n16.4 　交互式图形　　351\n16.4.1 　与图形交互：鉴别点　　351\n16.4.2 　playwith　　352\n16.4.3 　latticist　　353\n16.4.4 　iplots包的交互图形　　354\n16.4.5 　rggobi　　355\n16.5 　小结　　356\n后记：探索R的世界　　357\n附录A 　图形用户界面　　359\n附录B 　自定义启动环境　　362\n附录C 　从R中导出数据　　364\n附录D 　制作出版级品质的输出　　366\n附录E 　R中的矩阵运算　　374\n附录F 　本书中用到的扩展包　　376\n附录G 　处理大数据　　381\n附录H 　更新R　　383\n参考文献　　385","ebook_url":"https://read.douban.com/ebook/1132951/","pages":"388","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s24576400.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s24576400.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s24576400.jpg"},"alt":"https://book.douban.com/subject/20382244/","id":"20382244","publisher":"人民邮电出版社","isbn10":"7115299900","isbn13":"9787115299901","title":"R语言实战","url":"https://api.douban.com/v2/book/20382244","alt_title":"R in Action","author_intro":"Robert I. Kabacoff R语言社区著名学习网站Quick-Rhttp://www.statmethods.net/）的幕后维护者，现为全球化开发与咨询公司Management研究集团研发副总裁。此前，Kabacoff博士是佛罗里达诺瓦东南大学的教授，讲授定量方法和统计编程的研究生课程。Kabacoff还是临床心理学博士、统计顾问，擅长数据分析，在健康、金融服务、制造业、行为科学、政府和学术界有20余年的研究和统计咨询经验。","summary":"数据时代已经到来，但数据分析、数据挖掘人才却十分短缺。由于\u201c大数据\u201d对每个领域的决定性影响，　相对于经验和直觉，在商业、经济及其他领域中基于数据和分析去发现问题并作出科学、客观的决策越来越重要。开源软件R是世界上最流行的数据分析、统计计算及制图语言，几乎能够完成任何数据处理任务，可安装并运行于所有主流平台，为我们提供了成千上万的专业模块和实用工具，是从大数据中获取有用信息的绝佳工具。　　本书从解决实际问题入手，尽量跳脱统计学的理论阐述来讨论R语言及其应用，讲解清晰透澈，极具实用性。作者不仅高度概括了R语言的强大功能、展示了各种实用的统计示例，而且对于难以用传统方法分析的凌乱、不完整和非正态的数据也给出了完备的处理方法。通读本书，你将全面掌握使用R语言进行数据分析、数据挖掘的技巧，并领略大量探索和展示数据的图形功能，从而更加高效地进行分析与沟通。想要成为倍受高科技企业追捧的、炙手可热的数据分析师吗？想要科学分析数据并正确决策吗？不妨从本书开始，挑战大数据，用R开始炫酷的数据统计与分析吧！　　本书内容：　　R安装与操作\n数据导入/导出及格式化双变量关系的描述性分析回归分析\n模型适用性的评价方法以及结果的可视化\n用图形实现变量关系的可视化\n在给定置信度的前提下确定样本量\n高级统计分析方法和高级绘图","ebook_price":"40.00","price":"79.00元"},{"rating":{"max":10,"numRaters":136,"average":"8.8","min":0},"subtitle":"本书是极负盛名的C语言入门经典教材，其第一版发行至今已有二十年的历史 !","author":["（美）Stephen Kochan"],"pubdate":"2006年","tags":[{"count":603,"name":"c语言","title":"c语言"},{"count":318,"name":"C语言编程","title":"C语言编程"},{"count":297,"name":"编程","title":"编程"},{"count":275,"name":"入门","title":"入门"},{"count":273,"name":"计算机","title":"计算机"},{"count":208,"name":"程序设计","title":"程序设计"},{"count":151,"name":"c","title":"c"},{"count":130,"name":"教程","title":"教程"}],"origin_title":"","image":"https://img3.doubanio.com/view/subject/m/public/s26387712.jpg","binding":"平装","translator":["张小潘"],"catalog":"","pages":"543 页","images":{"small":"https://img3.doubanio.com/view/subject/s/public/s26387712.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s26387712.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s26387712.jpg"},"alt":"https://book.douban.com/subject/1786294/","id":"1786294","publisher":"电子社博文视点资讯有限公司","isbn10":"7121007355","isbn13":"9787121007354","title":"C语言编程：一本全面的C语言入门教程（第三版）","url":"https://api.douban.com/v2/book/1786294","alt_title":"Programming in C：A Complete introduction to the C programming language，Third Edition","author_intro":"","summary":"本书是极负盛名的C语言入门经典教材，其第一版发行至今已有20年的历史。本书内容详实全面，由浅入深，示例丰富，并在每个章节后面附有部分习题，非常适合读者自学使用。除此之外，《C语言编程》一书对于C语言标准的最新进展、C语言常见开发工具以及管理C语言大型项目等重要方面，也进行了深入浅出的说明。","price":"59.00元"}]
     */

    private int count;
    private int start;
    private int total;
    private List<BooksBean> books;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean {
        /**
         * rating : {"max":10,"numRaters":1560,"average":"8.9","min":0}
         * subtitle : C语言描述
         * author : ["维斯"]
         * pubdate : 2004-1-1
         * tags : [{"count":1904,"name":"数据结构","title":"数据结构"},{"count":1502,"name":"算法","title":"算法"},{"count":773,"name":"计算机","title":"计算机"},{"count":648,"name":"数据结构与算法分析","title":"数据结构与算法分析"},{"count":601,"name":"编程","title":"编程"},{"count":530,"name":"C","title":"C"},{"count":496,"name":"算法、数据结构","title":"算法、数据结构"},{"count":377,"name":"C语言","title":"C语言"}]
         * origin_title : Data Structures and Algorithm Analysis in C:Second Edition
         * image : https://img3.doubanio.com/view/subject/m/public/s28015501.jpg
         * binding : 平装
         * translator : ["冯舜玺"]
         * catalog : 第1章 引论
         1．1 本书讨论的内容
         1．2 数学知识复习
         1．2．1 指数
         1．2．2 对数
         1．2．3 级数
         1．2．4 模运算
         1. 2．5 证明方法
         1．3 递归简论
         总结
         练习
         参考文献
         第2章 算法分析
         2．1 数学基础
         2．2 模型
         2．3 要分析的问题
         2．4 运行时间计算
         2．4．1 一个简单的例子
         2．4．2 一般法则
         2．4．3 最大子序列和问题的解
         .2．4．4 运行时间中的对数
         2．4．5 检验你的分析
         2．4．6 分析结果的准确性
         总结
         练习
         参考文献
         第3章 表、栈和队列
         3．1 抽象数据类型(adt)
         3．2 表adt
         3．2．1 表的简单数组实现
         3．2．2 链表
         3．2．3 程序设计细节
         3．2．4 常见的错误
         3．2．5 双链表
         3．2．6 循环链表
         3．2．7 例子
         3．2．8 链表的游标实现
         3．3 栈adt
         3．3．1 栈模型
         3．3．2 栈的实现
         3．3．3 应用
         3．4 队列adt
         3．4．1 队列模型
         3．4．2 队列的数组实现
         3．4．3 队列的应用
         总结
         练习
         第4章 树
         4．1 预备知识
         4．1．1 树的实现
         4．1．2 树的遍历及应用
         4．2 二叉树
         4．2．1 实现
         4．2．2 表达式树
         4．3 查找树adt--二叉查找树
         4．3．1 makeempty
         4．3．2 find
         4．3．3 findmin和findmax
         4．3．4 insert
         4．3．5 delere
         4．3．6 平均情形分析
         4．4 avl树
         4．4．1 单旋转
         4．4．2 双旋转
         4．5 伸展树
         4．5．1 一个简单的想法
         4．5．2 展开
         4．6 树的遍历
         4．7 b-树
         总结
         练习
         参考文献
         第5章 散列
         5．1 一般想法
         5．2 散列函数
         5．3 分离链接法
         5．4 开放定址法
         5．4．1 线性探测法
         5．4．2 平方探测法
         5．4．3 双散列
         5．5 再散列
         5．6 可扩散列
         总结
         练习
         参考文献
         第6章 优先队列(堆)
         6．1 模型
         6．2 一些简单的实现
         6．3 二叉堆
         6．3．1 结构性质
         6．3．2 堆序性质
         6．3．3 基本的堆操作
         6．3．4 其他的堆操作
         6．4 优先队列的应用
         6．4．1 选择问题
         6．4．2 事件模拟
         6．5 d-堆
         6．6 左式堆
         6．6．1 左式堆的性质
         6．6．2 左式堆的操作
         6．7 斜堆
         6．8 二项队列
         6．8．1 二项队列结构
         6．8．2 二项队列操作
         6．8．3 二项队列的实现
         总结
         练习
         参考文献
         第7章 排序
         7．1 预备知识
         7．2 插入排序
         7．2．1 算法
         7．2．2 插入排序的分析
         7．3 一些简单排序算法的下界
         7. 4 希尔排序
         7．4．1 希尔排序的最坏情形分析
         7．5 堆排序
         7．5．1 堆排序的分析
         7．6 归并排序
         7．6．1 归并排序的分析
         7．7 快速排序
         7．7．1 选取枢纽元
         7．7．2 分割策略
         7．7．3 小数组
         7．7．4 实际的快速排序例程
         7．7．5 快速排序的分析
         7．7．6 选择的线性期望时间算法
         7．8 大型结构的排序
         7．9 排序的一般下界
         7．9．1 决策树
         7．10 桶式排序
         7．11 外部排序
         7．11．1 为什么需要新的算法
         7．11．2 外部排序模型
         7．11．3 简单算法
         7．11．4 多路合并
         7．11．5 多相合并
         7．11．6 替换选择
         总结
         练习
         参考文献
         第8章 不相交集adt
         8．1 等价关系
         8．2 动态等价性问题
         8．3 基本数据结构
         8．4 灵巧求并算法
         8．5 路径压缩
         8．6 按秩求并和路径压缩的最坏情形
         8．6．1 union／find算法分析
         8．7 一个应用
         总结
         练习
         参考文献
         第9章 图论算法
         9．1 若干定义
         9．1．1 图的表示
         9．2 拓扑排序
         9．3 最短路径算法
         9．3．1 无权最短路径
         9．3．2 dijkstra算法
         9．3．3 具有负边值的图
         9．3．4 无圈图
         9．3．5 所有点对最短路径
         9．4 网络流问题
         9．4．1 一个简单的最大流算法
         9．5 最小生成树
         9．5．1 prim算法
         9．5．2 kruskal算法
         9．6 深度优先搜索的应用
         9．6．1 无向图
         9．6．2 双连通性
         9．6．3 欧拉回路
         9．6．4 有向图
         9．6．5 查找强分支
         9．7 np-完全性介绍
         9．7．1 难与易
         9．7．2 np类
         9．7．3 np-完全问题
         总结
         练习
         参考文献
         第10章 算法设计技巧
         10．1 贪婪算法
         10．1．1 一个简单的调度问题
         10．1．2 huffman编码
         10．1．3 近似装箱问题
         10．2 分治算法
         10．2．1 分治算法的运行时间
         10．2．2 最近点问题
         10．2．3 选择问题
         10．2．4 一些运算问题的理论改进
         10．3 动态规划
         10．3．1 用一个表代替递归
         10．3．2 矩阵乘法的顺序安排
         10．3．3 最优二叉查找树
         10．3．4 所有点对最短路径
         10．4 随机化算法
         10．4．1 随机数发生器
         10．4．2 跳跃表
         10．4．3 素性测试
         10．5 回溯算法
         10．5．1 收费公路重建问题
         10．5．2 博弈
         总结
         练习
         参考文献
         第11章 摊还分析
         11．1 一个无关的智力问题
         11．2 二项队列
         11．3 斜堆
         11．4 斐波那契堆
         11．4．1 切除左式堆中的节点
         11．4．2 二项队列的懒惰合并
         11．4．3 斐波那契堆操作
         11．4．4 时间界的证明
         11. 5 伸展树
         总结
         练习
         参考文献
         第12章 高级数据结构及其实现
         12．1 自顶向下伸展树
         12．2 红黑树
         12．2．1 自底向上插入
         12．2．2 自顶向下红黑树
         12．2．3 自顶向下删除
         12．3 确定性跳跃表
         12．4 aa-树
         12．5 treap树
         12．6 k-d树
         12．7 配对堆
         总结
         练习
         参考文献
         索引
         * pages : 391
         * images : {"small":"https://img3.doubanio.com/view/subject/s/public/s28015501.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s28015501.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s28015501.jpg"}
         * alt : https://book.douban.com/subject/1139426/
         * id : 1139426
         * publisher : 机械工业出版社
         * isbn10 : 711112748X
         * isbn13 : 9787111127482
         * title : 数据结构与算法分析
         * url : https://api.douban.com/v2/book/1139426
         * alt_title : Data Structures and Algorithm Analysis in C:Second Edition
         * author_intro : Mark Allen Weiss，1987年在普林斯顿大学获得计算机科学博士学位，师从Robert Sedgewick (师从Knuth)，现任美国佛罗里达国际大学计算与信息科学学院教授。他曾经担任全美AP(Advanced Placement)考试计算机学科委员会的主席(2000-2004)。他的主要研究方向是数据结构、算法和教育学。
         * summary : 本书是《Data Structures and Algorithm Analysis in C》一书第2版的简体中译本。原书曾被评为20世纪顶尖的30部计算机著作之一，作者Mark Allen Weiss在数据结构和算法分析方面卓有建树，他的数据结构和算法分析的著作尤其畅销，并受到广泛好评．已被世界500余所大学用作教材。
         在本书中，作者更加精炼并强化了他对算法和数据结构方面创新的处理方法。通过C程序的实现，着重阐述了抽象数据类型的概念，并对算法的效率、性能和运行时间进行了分析。
         全书特点如下：
         ●专用一章来讨论算法设计技巧，包括贪婪算法、分治算法、动态规划、随机化算法以及回溯算法
         ●介绍了当前流行的论题和新的数据结构，如斐波那契堆、斜堆、二项队列、跳跃表和伸展树
         ●安排一章专门讨论摊还分析，考查书中介绍的一些高级数据结构
         ●新开辟一章讨论高级数据结构以及它们的实现，其中包括红黑树、自顶向下伸展树。treap树、k-d树、配对堆以及其他相关内容
         ●合并了堆排序平均情况分析的一些新结果
         本书是国外数据结构与算法分析方面的标准教材，介绍了数据结构(大量数据的组织方法)以及算法分析(算法运行时间的估算)。本书的编写目标是同时讲授好的程序设计和算法分析技巧，使读者可以开发出具有最高效率的程序。 本书可作为高级数据结构课程或研究生一年级算法分析课程的教材，使用本书需具有一些中级程序设计知识，还需要离散数学的一些背景知识。
         * series : {"id":"1163","title":"计算机科学丛书"}
         * price : 35.00元
         * ebook_url : https://read.douban.com/ebook/29284541/
         * ebook_price : 87.99
         */

        private RatingBean rating;
        private String subtitle;
        private String pubdate;
        private String origin_title;
        private String image;
        private String binding;
        private String catalog;
        private String pages;
        private ImagesBean images;
        private String alt;
        private String id;
        private String publisher;
        private String isbn10;
        private String isbn13;
        private String title;
        private String url;
        private String alt_title;
        private String author_intro;
        private String summary;
        private SeriesBean series;
        private String price;
        private String ebook_url;
        private String ebook_price;
        private List<String> author;
        private List<TagsBean> tags;
        private List<String> translator;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getOrigin_title() {
            return origin_title;
        }

        public void setOrigin_title(String origin_title) {
            this.origin_title = origin_title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBinding() {
            return binding;
        }

        public void setBinding(String binding) {
            this.binding = binding;
        }

        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getIsbn10() {
            return isbn10;
        }

        public void setIsbn10(String isbn10) {
            this.isbn10 = isbn10;
        }

        public String getIsbn13() {
            return isbn13;
        }

        public void setIsbn13(String isbn13) {
            this.isbn13 = isbn13;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlt_title() {
            return alt_title;
        }

        public void setAlt_title(String alt_title) {
            this.alt_title = alt_title;
        }

        public String getAuthor_intro() {
            return author_intro;
        }

        public void setAuthor_intro(String author_intro) {
            this.author_intro = author_intro;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public SeriesBean getSeries() {
            return series;
        }

        public void setSeries(SeriesBean series) {
            this.series = series;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getEbook_url() {
            return ebook_url;
        }

        public void setEbook_url(String ebook_url) {
            this.ebook_url = ebook_url;
        }

        public String getEbook_price() {
            return ebook_price;
        }

        public void setEbook_price(String ebook_price) {
            this.ebook_price = ebook_price;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<String> getTranslator() {
            return translator;
        }

        public void setTranslator(List<String> translator) {
            this.translator = translator;
        }

        public static class RatingBean {
            /**
             * max : 10
             * numRaters : 1560
             * average : 8.9
             * min : 0
             */

            private int max;
            private int numRaters;
            private String average;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/subject/s/public/s28015501.jpg
             * large : https://img3.doubanio.com/view/subject/l/public/s28015501.jpg
             * medium : https://img3.doubanio.com/view/subject/m/public/s28015501.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class SeriesBean {
            /**
             * id : 1163
             * title : 计算机科学丛书
             */

            private String id;
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class TagsBean {
            /**
             * count : 1904
             * name : 数据结构
             * title : 数据结构
             */

            private int count;
            private String name;
            private String title;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
