package com.lyh.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    String url = "http://www.de99.cn/news/1/13468.html";
    Document doc = null;
private final String neirong = "<b>01 </b><b>嫁给你才是我</b><b>这辈子最大的运气</b>2013—2016年间，我谢绝了香港某媒体的工作邀约，只在家闲散写稿作副业，整治熊孩子为正业。亲生好友来好言相劝：你作为一个祖国曾经的花朵，如今祖国的栋梁，读了那么多年书，你窝在家带孩子，你对得起你的才貌双全吗？是是是，我点头如捣蒜：我浪费了国家栽培，罔顾了天赋异禀，我的错。往前推三年。2013年，我完成了小女儿的哺乳事业，确实曾像女友说的那般，不辜负祖国人民对我的期望，紧锣密鼓，废寝忘食开始我红红火火的事业复苏。几个月后某天洗澡，摸到胸口有几颗红枣大的颗粒，一按就疼。过几日发展到，侧边睡都疼得龇牙咧嘴。我把这事儿告诉我婆婆。我婆婆安慰我说：我年轻时也有，你别看它摸上去大，实际上它比摸上去还大呢！婆婆，亲妈！婆婆的安慰即刻生效，从那天起，我夜不能寐，笼罩在一片胡思乱想的阴霾里。虽然我查了很多资料，数据证实哺乳过的女性患病几率偏低，但对照自己的症状越看越相像。在广州医院找了熟人紧急检查，从香港出发的那天，我给老李留了张字条：老公，我曾说你娶了我用了你毕生的运气，但其实，嫁给你才是我这辈子最大的运气。平时脾气不好，和你说声对不起。再给爸妈发了一条微信：我这两天去广州上课，勿担心，注意身体。眼睛湿了会儿补上一条：爱你们。<p><img src=\\\"http://www.de99.cn/tu/2016/111301.jpg\\\" /></p><b>02</b><b>上帝用虚惊一场</b><b>让我看清了自己要什么</b>检查结果出来后，初步鉴定是乳腺囊肿，我的医生朋友调侃我说：就是老酸奶的意思。我听了不觉好笑，锱铢必较地问：病变的几率是多大？他想了想说，很小。我还是把这几率很小的事杜绝在了手术床上。肿块比我和医生想的都大很多，手术时间比预期多了一小时。麻药过后我睁眼看到老李坐在我床边和护工阿姨一起愉快地看电视。迷迷瞪瞪中，觉得这是我人生中最美好的一幅画面。我仍然可以继续做他的老婆，可以继续做一双儿女的妈妈，可以继续做我父母的女儿。在这份侥幸重生的信念里，我并没有想到美貌如花，赚钱买大家，名满天下。我们没有上帝视角，评判绝对正误的人生，可我觉得自己很幸运，上帝用虚惊一场，让我看清了自己要什么。所以对于如今的我来说，不调理好身体，没有时间陪伴孩子度过0-3岁，没有自由身每年回家看望父母，没有闲余心性和老公你侬我侬有性生活。那么，等再有一天，老天不再是给予个玩笑警告，撸起袖子玩真的，我这一生都将是悔恨，又谈何成功？这个世界林林总总，斑斓或吊诡，其实众生皆虚妄。你以为那些似锦繁花为你盛开，莺歌燕舞为你升平，钵盆满盈待你去取。实则白眉赤眼来遭，为你落踏实这人生的，为你生老病死买单的，只有你的至亲挚爱。你也拿什么去爱他们？健康地活着就好。<b>03</b><b>你的人生到底图什么</b>《我是演说家》里，26岁的“最美律师”周西，在赛场上讲述了她三天前被查出拳头大卵巢囊肿的故事。她和母亲去医院验血，证实癌症指数比健康人高了6倍。她几度哽咽，艰难完成演说。她说：我有特别喜欢的人，像太阳一样闪闪发光，他帅气幽默内敛，他是一切美好的代名词，我一直想我要努力让他看到，有这么个女孩喜欢你，她还挺优秀的呢。所以她从来都是熬夜、忙碌、拼命。忙到检查出子宫有不均回声，吃了中药却没有复检，痛经痛到撕心裂肺没有在意，小肚子突出也只以为自己胖了。直到痛经痛到昏厥前拨打了120。我也曾像她那么拼，结束哺乳期后拼了命的节食减肥，忘情工作，熬夜笙歌。好把怀孕生子那些丢失的美好和智力都补回来。我不想从此籍籍无名，庸庸碌碌，却从未注意到自己的身体发出了警告——在囊肿之前，我已经几个月没有生理期，身体浮肿，脸色苍白。我的另一个朋友，常年左耳嗡嗡响，他觉得是小毛病，工作太忙没有在意，却在某一天耳内雷声大作，左耳永久失聪。我的女友和我说，为了给孩子更好的生活，疲于奔命，回到家要抱一抱女儿一解疲乏，女儿却哭闹着往保姆身后躲。她当场落泪。而她自己，被工作困得失眠焦虑，常年依赖安眠药。她说，我也不知道我图什么。我的另一个女友跟我说，她开始偷偷收藏一些养生秘籍，健康知识，就想着早点退休，颐养天年。可总羞于说出口，因为在这个年纪里，不拼搏不勤奋，就是逆流而行的偷安怠惰。<b>04</b><b>更好的生活方式</b>《人类简史——从动物到上帝》这本书，讲述了智人如何快速登顶生物链顶端的进程。几万年前，我们祖先从部落迁徙的采集社会，进入农业社会时，史学家认为农业革命是人类文明进步的里程碑。实际上，承载到个体的生活质量却产生了倒退。狩猎者生活方式多变，食物品类繁多。农耕者囿于屋舍，谷物为主的食物营养缺失，难以消化。狩猎者身手矫健，寿命更长。农耕者弯腰农作，开始有了椎间盘突出、关节炎，还受到瘟疫的威胁。狩猎者遇到天灾，可以全身而退。农耕者看似得来了躲风避雨的安稳，人口暴涨，却还是看天吃饭，常遭遇饥荒。可是既然我们过得并不好，为什么不倒退回采集社会呢？因为我们所有改变点点滴滴，经过了几世几代，我们已不再记得，我们拥有更好生活方式的选择。我们以为我们驯服了小麦，实际上是小麦驯服了我们。几万年后，人类早就从成熟的农业社会更迭到了工业社会。我们依旧沿袭创造生产力和财富的路数，被“社会价值”裹挟着，在疲于奔命的路上一去不返。忘记了我们可以田园牧歌，可以天伦叙乐，可以选择一副更健康愉悦的体魄，更闲适自在的生活。我们以为我们能控制工作，实际上是工作绑架了我们。君不见我们咬紧牙关什么都想要，却看不到姚贝娜金波张斌张锐，那些少年得志却猝然离世的精英们。张爱玲说，人生有三大遗憾：鲥鱼多刺，海棠无香，高鹗续《红楼》。其实这三大遗憾都是幡动心动，阳春白雪之憾。待我经历过伪生离死别，得来凡夫俗子最大憾：无非是意外早于未来，而你仍有牵挂之爱。向死而生，我们偶尔诞临，殊途同归走向公平的宿命。可我们总能够把这份偶然变得更厚润更绵长更无憾。<b>如果可以，剔掉聚餐，一年体检一次。</b><b>如果可以，放下手机，陪你的孩子嬉戏。</b><b>如果可以，工作再忙也要有性生活。</b><b>如果可以，长假请把景点定在父母家里。</b>因为这个世界“没有如果，只有结果和后果”。";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("1111", "run: doc ++ ");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doc = Jsoup.parse(new URL(url), 5000);
                    //doc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i("1111", "run: e");
                }
            }
        });
        thread.start();
        // String content = GetDocContent(doc);
        // System.out.println("网页正文如下：\n" + content);
        Log.i("1111","string = " + neirong);
        filterContent();

    }

    private void filterContent() {


    }

    private String GetDocContent(Document doc) {
        Elements divs = doc.body().getElementsByTag("div");
        int max = -1;
        String content = null;
        for (int i = 0; i < divs.size(); i++) {
            Element div = (Element) divs.get(i);
            String divContent = GetDivContent(div);
            if (divContent.length() > max) {
                max = divContent.length();
                content = divContent;
            }
        }
        return content;
    }

    private String GetDivContent(Element div) {
        StringBuilder sb = new StringBuilder();
//考虑div里标签内容的顺序，对div子树进行深度优先搜索
        Stack<Element> sk = new Stack<Element>();
        sk.push(div);
        while (!sk.empty()) {
            //
            Element e = sk.pop();
            //对于div中的div过滤掉
            if (e != div && e.tagName().equals("div")) continue;
            //考虑正文被包含在p标签中的情况，并且p标签里不能含有a标签
            if (e.tagName().equals("p") && e.getElementsByTag("a").size() == 0) {
                String className = e.className();
                if (className.length() != 0 && className.equals("pictext")) continue;
                sb.append(e.text());
                sb.append("\n");
                continue;
            } else if (e.tagName().equals("td")) {
                //考虑正文被包含在td标签中的情况
                if (e.getElementsByTag("div").size() != 0) continue;
                sb.append(e.text());
                sb.append("\n");
                continue;

            }
            //将孩子节点加入栈中
            Elements children = e.children();
            for (int i = children.size() - 1; i >= 0; i--) {
                sk.push((Element) children.get(i));
            }
        }

        return sb.toString();
    }

}
