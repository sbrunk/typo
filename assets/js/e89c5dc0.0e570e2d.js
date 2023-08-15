"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[625],{3905:(e,t,n)=>{n.d(t,{Zo:()=>c,kt:()=>y});var o=n(7294);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function r(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);t&&(o=o.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,o)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?r(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):r(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function l(e,t){if(null==e)return{};var n,o,a=function(e,t){if(null==e)return{};var n,o,a={},r=Object.keys(e);for(o=0;o<r.length;o++)n=r[o],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(o=0;o<r.length;o++)n=r[o],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var u=o.createContext({}),s=function(e){var t=o.useContext(u),n=t;return e&&(n="function"==typeof e?e(t):i(i({},t),e)),n},c=function(e){var t=s(e.components);return o.createElement(u.Provider,{value:t},e.children)},d="mdxType",m={inlineCode:"code",wrapper:function(e){var t=e.children;return o.createElement(o.Fragment,{},t)}},p=o.forwardRef((function(e,t){var n=e.components,a=e.mdxType,r=e.originalType,u=e.parentName,c=l(e,["components","mdxType","originalType","parentName"]),d=s(n),p=a,y=d["".concat(u,".").concat(p)]||d[p]||m[p]||r;return n?o.createElement(y,i(i({ref:t},c),{},{components:n})):o.createElement(y,i({ref:t},c))}));function y(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var r=n.length,i=new Array(r);i[0]=p;var l={};for(var u in t)hasOwnProperty.call(t,u)&&(l[u]=t[u]);l.originalType=e,l[d]="string"==typeof e?e:a,i[1]=l;for(var s=2;s<r;s++)i[s]=n[s];return o.createElement.apply(null,i)}return o.createElement.apply(null,n)}p.displayName="MDXCreateElement"},1490:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>u,contentTitle:()=>i,default:()=>m,frontMatter:()=>r,metadata:()=>l,toc:()=>s});var o=n(7462),a=(n(7294),n(3905));const r={},i=void 0,l={unversionedId:"testing-with-random-values",id:"testing-with-random-values",title:"testing-with-random-values",description:"This covers a lot of interesting ground, test-wise.",source:"@site/docs/testing-with-random-values.md",sourceDirName:".",slug:"/testing-with-random-values",permalink:"/typo/docs/testing-with-random-values",draft:!1,tags:[],version:"current",frontMatter:{},sidebar:"tutorialSidebar",previous:{title:"testing-with-stubs",permalink:"/typo/docs/testing-with-stubs"},next:{title:"json",permalink:"/typo/docs/json"}},u={},s=[{value:"Usage example",id:"usage-example",level:3},{value:"Comparison with scalacheck",id:"comparison-with-scalacheck",level:3}],c={toc:s},d="wrapper";function m(e){let{components:t,...n}=e;return(0,a.kt)(d,(0,o.Z)({},c,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("p",null,"This covers a lot of interesting ground, test-wise."),(0,a.kt)("p",null,"If you enable ",(0,a.kt)("inlineCode",{parentName:"p"},"enableTestInserts")," in ",(0,a.kt)("inlineCode",{parentName:"p"},"typo.Options")," you now get an ",(0,a.kt)("inlineCode",{parentName:"p"},"testInsert")," class, with a method to insert a row for each table ",(0,a.kt)("inlineCode",{parentName:"p"},"typo")," knows about.\nAll values except ids, foreign keys and so on are ",(0,a.kt)("em",{parentName:"p"},"randomly generated"),", but you can override them with named parameters."),(0,a.kt)("p",null,"The idea is that you:"),(0,a.kt)("ul",null,(0,a.kt)("li",{parentName:"ul"},"can easily insert rows for testing"),(0,a.kt)("li",{parentName:"ul"},"can explicitly set the values you ",(0,a.kt)("em",{parentName:"li"},"do")," care about"),(0,a.kt)("li",{parentName:"ul"},"will get random values for the rest"),(0,a.kt)("li",{parentName:"ul"},"are still forced to follow FKs to setup the data graph correctly"),(0,a.kt)("li",{parentName:"ul"},"it's easy to follow those FKs, because after inserting a row you get the persisted version back, including generated IDs"),(0,a.kt)("li",{parentName:"ul"},"can get the same values each time by hard coding the seed ",(0,a.kt)("inlineCode",{parentName:"li"},"new testInsert(new scala.util.Random(0L))"),", or you can run it multiple times with different seeds to see that the random values really do not matter"),(0,a.kt)("li",{parentName:"ul"},"do not need to write ",(0,a.kt)("em",{parentName:"li"},"any")," code to get all this available to you, like the rest of ",(0,a.kt)("inlineCode",{parentName:"li"},"typo"),".")),(0,a.kt)("p",null,"In summary, this is a fantastic way of setting up complex test scenarios in the database!"),(0,a.kt)("h3",{id:"usage-example"},"Usage example"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-scala"},'import adventureworks.production.unitmeasure.UnitmeasureId\nimport adventureworks.{testInsert, Defaulted, TypoXml}\n\nimport scala.util.Random\n\nval testInsert = new testInsert(new Random(0))\n// testInsert: testInsert = adventureworks.testInsert@47db041b\n\nval unitmeasure = testInsert.productionUnitmeasure(UnitmeasureId("kgg"))\n// unitmeasure: UnitmeasureRow = UnitmeasureRow(\n//   unitmeasurecode = UnitmeasureId(value = "kgg"),\n//   name = Name(value = "CCzLNHBFHuRvbI1iI19W"),\n//   modifieddate = TypoLocalDateTime(value = 2023-08-16T00:34:29.246584)\n// )\nval productCategory = testInsert.productionProductcategory()\n// productCategory: ProductcategoryRow = ProductcategoryRow(\n//   productcategoryid = ProductcategoryId(value = 11),\n//   name = Name(value = "jGGR8UNWutFRZvWebpA5"),\n//   rowguid = e5b04ff6-3bbb-11ee-989a-0242ac160002,\n//   modifieddate = TypoLocalDateTime(value = 2023-08-16T00:34:29.246584)\n// )\nval productSubcategory = testInsert.productionProductsubcategory(productCategory.productcategoryid)\n// productSubcategory: ProductsubcategoryRow = ProductsubcategoryRow(\n//   productsubcategoryid = ProductsubcategoryId(value = 11),\n//   productcategoryid = ProductcategoryId(value = 11),\n//   name = Name(value = "WHfyqts0coJXQqPyuxbr"),\n//   rowguid = e5b39706-3bbb-11ee-989a-0242ac160002,\n//   modifieddate = TypoLocalDateTime(value = 2023-08-16T00:34:29.246584)\n// )\nval productModel = testInsert.productionProductmodel(catalogdescription = Some(new TypoXml("<xml/>")), instructions = Some(new TypoXml("<instructions/>")))\n// productModel: ProductmodelRow = ProductmodelRow(\n//   productmodelid = ProductmodelId(value = 14),\n//   name = Name(value = "589wyJzS2SuiHrAOB2Ru"),\n//   catalogdescription = Some(value = TypoXml(value = "<xml/>")),\n//   instructions = Some(value = TypoXml(value = "<instructions/>")),\n//   rowguid = e5b834b4-3bbb-11ee-989a-0242ac160002,\n//   modifieddate = TypoLocalDateTime(value = 2023-08-16T00:34:29.246584)\n// )\ntestInsert.productionProduct(\n  sizeunitmeasurecode = Some(unitmeasure.unitmeasurecode),\n  weightunitmeasurecode = Some(unitmeasure.unitmeasurecode),\n  `class` = Some("H "),\n  style = Some("W "),\n  productsubcategoryid = Some(productSubcategory.productsubcategoryid),\n  productmodelid = Some(productModel.productmodelid)\n)\n// res1: ProductRow = ProductRow(\n//   productid = ProductId(value = 11),\n//   name = Name(value = "vBbFbQPNB7ZuKSWpBejT"),\n//   productnumber = "wv1NdpH7sjiP63hvGdgZ",\n//   makeflag = Flag(value = true),\n//   finishedgoodsflag = Flag(value = true),\n//   color = None,\n//   safetystocklevel = 21170,\n//   reorderpoint = 27774,\n//   standardcost = 0.9043197434746348,\n//   listprice = 0.2871518999993117,\n//   size = None,\n//   sizeunitmeasurecode = Some(value = UnitmeasureId(value = "kgg")),\n//   weightunitmeasurecode = Some(value = UnitmeasureId(value = "kgg")),\n//   weight = Some(value = 0.32),\n//   daystomanufacture = 412901507,\n//   productline = None,\n//   class = Some(value = "H "),\n//   style = Some(value = "W "),\n//   productsubcategoryid = Some(value = ProductsubcategoryId(value = 11)),\n//   productmodelid = Some(value = ProductmodelId(value = 14)),\n//   sellstartdate = TypoLocalDateTime(value = 2003-07-12T04:09:01),\n//   sellenddate = None,\n//   discontinueddate = None,\n//   rowguid = e5bc44c8-3bbb-11ee-989a-0242ac160002,\n//   modifieddate = TypoLocalDateTime(value = 2023-08-16T00:34:29.246584)\n// )\n')),(0,a.kt)("h3",{id:"comparison-with-scalacheck"},"Comparison with scalacheck"),(0,a.kt)("p",null,"This does look a lot like scalacheck indeed."),(0,a.kt)("p",null,"But look closer, there are:"),(0,a.kt)("ul",null,(0,a.kt)("li",{parentName:"ul"},"no implicits"),(0,a.kt)("li",{parentName:"ul"},"no integration glue code with test libraries"),(0,a.kt)("li",{parentName:"ul"},"almost no imports, you need to mention very few types"),(0,a.kt)("li",{parentName:"ul"},"no keeping track of all the possible row types and repositories"),(0,a.kt)("li",{parentName:"ul"},"and so on")),(0,a.kt)("p",null,"This feature is meant to be easy to use, and I really think/hope it is!"))}m.isMDXComponent=!0}}]);