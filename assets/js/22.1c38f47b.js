(window.webpackJsonp=window.webpackJsonp||[]).push([[22],{480:function(t,a,e){"use strict";e.r(a);var r=e(20),s=Object(r.a)({},(function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[e("h1",{attrs:{id:"sharding"}},[e("a",{staticClass:"header-anchor",attrs:{href:"#sharding"}},[t._v("#")]),t._v(" Sharding")]),t._v(" "),e("blockquote",[e("p",[t._v("分片")])]),t._v(" "),e("p",{attrs:{align:"center"}},[e("img",{attrs:{src:t.$withBase("/assets/design/Sharding-impl-class.png"),alt:"Sharding implementation class diagram"}})]),t._v(" "),e("h2",{attrs:{id:"cachedsharding"}},[e("a",{staticClass:"header-anchor",attrs:{href:"#cachedsharding"}},[t._v("#")]),t._v(" CachedSharding")]),t._v(" "),e("blockquote",[e("p",[t._v("已缓存的分区，对Sharding子类具体实现的包装，内部通过具体的"),e("code",[t._v("Sharding")]),t._v("进行分区，目的为了通过缓存减少内存对象，提升整体性能。")])]),t._v(" "),e("h2",{attrs:{id:"intervaltimeline"}},[e("a",{staticClass:"header-anchor",attrs:{href:"#intervaltimeline"}},[t._v("#")]),t._v(" IntervalTimeline")]),t._v(" "),e("blockquote",[e("p",[t._v("按照时间间隔的分区，时间单位根据"),e("code",[t._v("ChronoUnit")]),t._v(", 比如："),e("code",[t._v("20220510")]),t._v("按照"),e("code",[t._v("ChronoUnit.MONTHS")]),t._v("进行分区，结果分区至"),e("code",[t._v("202205")])])]),t._v(" "),e("h2",{attrs:{id:"modcycle"}},[e("a",{staticClass:"header-anchor",attrs:{href:"#modcycle"}},[t._v("#")]),t._v(" ModCycle"),e("T")],1),t._v(" "),e("blockquote",[e("p",[t._v("可以提前预知节点数量的场，按照节点取模算法进行分区，比如在4个分区节点："),e("code",[t._v("0，1，2，3")]),t._v("，分区值为"),e("code",[t._v("3")]),t._v("，"),e("code",[t._v("4")]),t._v("的值会被分区至节点"),e("code",[t._v("3")]),t._v(","),e("code",[t._v("0")])])])])}),[],!1,null,null,null);a.default=s.exports}}]);