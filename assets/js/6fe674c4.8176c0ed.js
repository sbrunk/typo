"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[794],{3905:(e,t,n)=>{n.d(t,{Zo:()=>c,kt:()=>u});var r=n(7294);function o(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function a(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?a(Object(n),!0).forEach((function(t){o(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):a(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function s(e,t){if(null==e)return{};var n,r,o=function(e,t){if(null==e)return{};var n,r,o={},a=Object.keys(e);for(r=0;r<a.length;r++)n=a[r],t.indexOf(n)>=0||(o[n]=e[n]);return o}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(r=0;r<a.length;r++)n=a[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(o[n]=e[n])}return o}var p=r.createContext({}),l=function(e){var t=r.useContext(p),n=t;return e&&(n="function"==typeof e?e(t):i(i({},t),e)),n},c=function(e){var t=l(e.components);return r.createElement(p.Provider,{value:t},e.children)},d="mdxType",m={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},y=r.forwardRef((function(e,t){var n=e.components,o=e.mdxType,a=e.originalType,p=e.parentName,c=s(e,["components","mdxType","originalType","parentName"]),d=l(n),y=o,u=d["".concat(p,".").concat(y)]||d[y]||m[y]||a;return n?r.createElement(u,i(i({ref:t},c),{},{components:n})):r.createElement(u,i({ref:t},c))}));function u(e,t){var n=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var a=n.length,i=new Array(a);i[0]=y;var s={};for(var p in t)hasOwnProperty.call(t,p)&&(s[p]=t[p]);s.originalType=e,s[d]="string"==typeof e?e:o,i[1]=s;for(var l=2;l<a;l++)i[l]=n[l];return r.createElement.apply(null,i)}return r.createElement.apply(null,n)}y.displayName="MDXCreateElement"},368:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>p,contentTitle:()=>i,default:()=>m,frontMatter:()=>a,metadata:()=>s,toc:()=>l});var r=n(7462),o=(n(7294),n(3905));const a={},i=void 0,s={unversionedId:"type-flow",id:"type-flow",title:"type-flow",description:'typo follows "dependencies" between postgres columns (foreign keys and view dependencies) so the',source:"@site/docs/type-flow.md",sourceDirName:".",slug:"/type-flow",permalink:"/typo/docs/type-flow",draft:!1,tags:[],version:"current",frontMatter:{},sidebar:"tutorialSidebar",previous:{title:"typo-types",permalink:"/typo/docs/typo-types"},next:{title:"scala-js-ready",permalink:"/typo/docs/scala-js-ready"}},p={},l=[{value:"Example generated row with type flow",id:"example-generated-row-with-type-flow",level:2}],c={toc:l},d="wrapper";function m(e){let{components:t,...n}=e;return(0,o.kt)(d,(0,r.Z)({},c,n,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("p",null,(0,o.kt)("inlineCode",{parentName:"p"},"typo"),' follows "dependencies" between postgres columns (foreign keys and view dependencies) so the\nmore specific types (like ',(0,o.kt)("a",{parentName:"p",href:"/typo/docs/id-types"},"id types")," and ",(0,o.kt)("a",{parentName:"p",href:"/typo/docs/user-selected-types"},"user-selected-types"),') can "flow"\ndownstream from the base column to other tables which reference it.'),(0,o.kt)("p",null,"This makes it way easier to follow these relationships when coding against the generated code."),(0,o.kt)("p",null,"Information about the dependencies are encoded in comments in the generated code,\nlook below for things like"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-scala"},"// Points to [[department.DepartmentRow.departmentid]]\n")),(0,o.kt)("p",null,"These are by the way scaladoc links which can be ctrl-clicked in intellij to go to that column."),(0,o.kt)("h2",{id:"example-generated-row-with-type-flow"},"Example generated row with type flow"),(0,o.kt)("p",null,'In this example you can see that id types from other tables have "flowed" into this table\nthrough a foreign key, and you can see that the table has a composite id.'),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-scala"},"import adventureworks.TypoLocalDate\nimport adventureworks.TypoLocalDateTime\nimport adventureworks.humanresources.employeedepartmenthistory.EmployeedepartmenthistoryId\nimport adventureworks.humanresources.department.DepartmentId\nimport adventureworks.humanresources.shift.ShiftId\nimport adventureworks.person.businessentity.BusinessentityId\n\ncase class EmployeedepartmenthistoryRow(\n  /** Employee identification number. Foreign key to Employee.BusinessEntityID.\n      Points to [[employee.EmployeeRow.businessentityid]] */\n  businessentityid: BusinessentityId,\n  /** Department in which the employee worked including currently. Foreign key to Department.DepartmentID.\n      Points to [[department.DepartmentRow.departmentid]] */\n  departmentid: DepartmentId,\n  /** Identifies which 8-hour shift the employee works. Foreign key to Shift.Shift.ID.\n      Points to [[shift.ShiftRow.shiftid]] */\n  shiftid: ShiftId,\n  /** Date the employee started work in the department. */\n  startdate: TypoLocalDate,\n  /** Date the employee left the department. NULL = Current department. */\n  enddate: Option[TypoLocalDate],\n  modifieddate: TypoLocalDateTime\n){\n   val compositeId: EmployeedepartmenthistoryId = EmployeedepartmenthistoryId(businessentityid, startdate, departmentid, shiftid)\n }\n\nobject EmployeedepartmenthistoryRow {\n  // ...instances\n}\n")))}m.isMDXComponent=!0}}]);