#1. 用户模块
##1.1 简述
用户模块负责用户基本信息的修改和处理，负责登录，注册，找回密码，修改个人信息，修改个人的隐私控制信息。

---
##1.2 功能
1. 登录，登录后保持登录，直到登录超时，或者执行过退出功能。
* 退出登录。
* 查询当前的登录状态
* 注册，不使用邮箱，需要填写用户名，密码，手机号码（需要验证）。验证过程请看[公共模块]()。
* 注册，使用邮箱，需要填写用户名，密码，手机号码（需要验证），邮箱（需要验证）。验证过程请看[公共模块]()。
* 登录状态下，验证自己的邮箱（当邮箱未验证时）包括
       发送验证码到用户指定的邮箱
       回填验证码，传给后台系统，后台返回绑定信息。
* 登录状态下，验证自己的手机（当手机未验证时）包括
       发送验证码到用户指定的手机
       回填验证码，传给后台系统，后台返回绑定信息。
* 登录状态下，验证密保，执行敏感操作，其中包括
       查询用户当前拥有的密保手段
       选择其中的一种方式，发送手机短信或者邮箱验证码
       回填验证码，验证密保。
* 敏感操作
9.1 修改手机号码
验证密保之后，可以修改手机号码，其中包括
       发送验证短信
       回填验证短信，系统验证成功后，修改手机号码
9.2 修改邮箱，类似9.1的过程。略
9.3 修改密码（用户打开了 **修改密码时验证密保**）若已经验证密保，可以不输入旧密码，直接更改密码。
* 登录状态下，修改密码（用户关闭了 **修改密码时验证密保**），需要输入旧密码和新密码。
* 登录状态下，打开 **修改密码时验证密保**
* 登录状态下，若关闭 **修改密码时验证密保** 需要验证密保，验证成功后可以关闭。

---
##1.3 附加说明
1. 手机短信验证码和邮箱验证码的有效时间 30分钟
* 验证密保完毕之后，用户需要在30分钟内完成自己的敏感操作，超时将需要重新验证。
* 登录后若30分钟不操作，且不续租（访问 [3]()），将会退出登录
* 以下是用户的基本信息要求
       用户名：6-20位字符串，且不能是邮箱，首字母不能是数字
       密码：6-20位任意字符
       邮箱：最长邮箱长度为 50个字符
       手机号码：国家区号 + 手机号码，例如： +8618866668888
* 以下是用户的个人控制权限
       打开或者关闭 **修改密码时验证密保**

----
#2. 公共模块
##2.1 概述
公共板块提供注册的一些基本信息查询和一些公共公开信息的查询

---
##2.2 功能
1. 查询手机号码是否被使用
* 查询邮箱是否被使用了
* 查询用户名是否被使用了
* 查询支持的城市列表
* 查询支持的国家列表
* 注册时验证手机信息 包括
       发送短信
       用户回填验证码，系统验证。
* 注册时验证邮箱信息 过程类似于 上面
* 找回密码，包括以下步骤
8.1 验证密保，包括
       不登陆状态下，查询用户当前拥有的密保手段
       选择其中的一种方式，发送手机短信或者邮箱验证码
       回填验证码，验证密保
8.2 重设密码

---
##2.3 附加说明
1. 验证手机或者邮箱的有效期为30分钟，过期后用户将需要重新验证。
* 验证密保后，用户需要在30分钟内完成重设密码，过期后需要重新验证密保

---
#3. 组织模块
##3.1 概述
组织模块负责对组织的创建，组织信息的管理，组织的基本设置，组织的父组织信息制定，组织的创建者（最高权限者）的制定和转让等。

---
##3.2 功能
1. 创建组织，提供基本的组织信息，即可创建一个组织
* 修改组织基本信息
* 获取用户在组织内的职务（是否是创建者或者管理员等等）
* 向外申请父组织
* 撤回向外申请父组织
* 处理其他组织父组织的申请
* 向外申请解除父组织
* 撤回向外申请解除父组织
* 处理其他组织接触申请父组织的申请
* 申请转让组织的创建者（包括附带子部门和不附带子部门）
* 撤回申请转让组织的创建者（包括附带子部门和不附带子部门）
* 处理转让组织的创建者的申请（包括附带子部门和不附带子部门）
* 组织的创建者任命组织的最高管理者，这个操作需要向被任命的人发送申请
* 处理最高管理者的任命，每个组织最多设置10个最高管理者
* 裁撤最高管理者
* 搜索组织
* 删除组织
* 发布公告
* 删除公告

---
##3.3 附加说明
1. 组织的基本属性
       组织名：6-250个字符，要求不能有反动，暴力，色情的字眼
       组织所在地：要求选择本系统支持的地区
       父组织：只能有一个，不能循环继承
       最高管理者：【隐藏属性】极高权限（宰相）
       创建者：【隐藏属性】最高权限（皇帝）
* 关于防止循环父组织，假如A是B的父组织,B是C的父组织，那么，C不能作为A的父组织
* 创建者不能是最高管理员
* 创建一个组织后，将会自动创建一个永久会话，详情请见 [会话模块]()
* 所有申请默认在1年内有效
* 组织的创建者和最高管理者的默认权限设置

|功能|创建者|最高管理者|
|--|---|-----|
|创建部门|√|√|
|修改组织基本信息|√|√|
|修改子部门基本信息|√|询问|
|删除组织|√|×|
|删除部门|√|×|
|授予某个用户部门创建者|√|询问|
|授予某个用户部门最高管理者|√|询问|
|公告管理|√|√|

---
#4. 部门模块
##4.1 概述
部门模块负责部门的创建，部门信息的管理

---
##4.2 功能
1. 特定角色可以在组织下创建一个部门，并且让组织的创建者成为部门的创建者
* 特定角色在当前部门下新建子部门，并且让本部门的创建者成为这个子部门的创建者
* 特定角色为一个部门指定一个最高管理者提交申请
* 处理部门指定最高管理者的申请
* 撤销部门指定最高管理者的申请
* 以下角色为组织的创建者转移子部门的创建者提交申请
* 撤销部门指定创建者的申请
* 处理部门指定创建者的申请
* 特定角色可以删除部门，不可撤销
* 特定角色可以修改组织的基本信息
* 特定角色为部门上传文件
* 特定角色获取部门文件列表
* 特定角色删除部门文件
* 特定角色发布公告
* 特定角色删除公告

---
##4.3 附加说明
1. 创建者不能是最高管理者
* 一个部门创建后，会自动创建一个会话 详情请见[会话模块]()
* 一个部门创建后，会自动创建文件库
* 下表说明了上面操作的权限

|功能|部门所属组织的创建者|部门所属组织的最高管理者|部门的创建者|部门的最高管理者|
|--|----------|-----------|------|--------|
|在组织下创建一个部门|√|√|不可用|不可用|
|在本部门下创建一个子部门|√|√|√|√|
|为一个部门指定一个最高管理者|√|√|√|×|
|为组织的创建者转移子部门的创建者|√|√|√|×|
|删除部门|√|√|√|×|
|文件管理|√|√|√|√|
|公告管理|√|√|√|√|

---
#5 会话模块
##5.1 概述
会话模块提供交流信息的功能，同时提供会话的创建，销毁，临时会话的空值，实时消息的发送和接收。

---
##5.2 功能
1. 获取当前拥有的所有会话
* 在会话中发送消息，其中包括
      上传必要的文件，包括音频（语音），图片，附件文件，表情，文档等等
      发送消息
* 撤回消息
* 获取当前所有会话的未读信息数目
* 接收所有未读消息
* 把未读消息编程已读消息

---
##5.3 附加说明
1. 待更新
* 待更新

---
#6 职位模块
##6.1 概述
职位模块负责用户在组织内的职位

---
##6.2 功能
1. 待更新
* 待更新

---
##6.3 附加说明
1. 待更新
* 待更新

---
#7 好友模块
##7.1 概述
负责用户的好友管理
---
##7.2 功能
1. 待更新
* 待更新

---
##7.3 附加说明
1. 待更新
* 待更新

---
#8 邮箱模块
##8.1 概述
负责用户的邮箱，职位的邮箱的邮件处理等等

---
##8.2 功能
1. 待更新
* 待更新

---
##8.3 附加说明
1. 待更新
* 待更新

---