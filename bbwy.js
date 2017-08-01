var scene = null;
	var camera = null;
	var renderer = null;
	var controls = null;
	var Devices = null;
	var clock = new THREE.Clock();
	var raycaster = null;
	var INTERSECTED = null;
	var mouse = null;
	var qiang0 = 10;
	var qiang1 = 10;
	var turn_peson = true;
	var global_VR = true;

	function IsPC() {
		var userAgentInfo=navigator.userAgent;var Agents=new Array("Android","iPhone","SymbianOS","Windows Phone","iPad","iPod");var flag=true;for(var v=0;v<Agents.length;v++){if(userAgentInfo.indexOf(Agents[v])>0){flag=false;break}}return flag
	}
;
;
	var global_is_pc = IsPC();

	function range(a,b){var result=[];for(var i=a;i<b;i++){result.push(i)}return result}

	function list_rm(list,a){for(var i=0;i<list.length;i++){if(list[i]===a){list.splice(i,1);break}}}const global_qipan=range(2,83);const global_qizi0=global_qipan[global_qipan.length-1]+1;const global_qizi1=global_qizi0+1;const global_qiangh=global_qizi1+1;const global_qiangs=global_qiangh+1;const global_delete=global_qiangs+1;const global_qianglist=[];

	function init(){scene=new THREE.Scene();camera=new THREE.PerspectiveCamera(75,window.innerWidth/window.innerHeight,0.1,1000);camera.position.set(0,0,100);renderer=new THREE.WebGLRenderer();renderer.setSize(window.innerWidth,window.innerHeight);document.body.appendChild(renderer.domElement);var directionalLight=new THREE.DirectionalLight(0xffffff);directionalLight.position.set(-25,-25,10);directionalLight.name='-1';scene.add(directionalLight);var directionalLight=new THREE.DirectionalLight(0xffffff);directionalLight.position.set(25,25,10);directionalLight.name='-2';scene.add(directionalLight);raycaster=new THREE.Raycaster();mouse=new THREE.Vector2();if(global_is_pc){camera.lookAt(new THREE.Vector3(0,0,0));controls=new THREE.OrbitControls(camera);document.addEventListener('mousemove',function(event){event.preventDefault();mouse.x=(event.clientX/window.innerWidth)*2-1;mouse.y=-(event.clientY/window.innerHeight)*2+1;raycaster.setFromCamera(mouse,camera);document.addEventListener('click',_mouse_click,false)},false)}else{camera.lookAt(new THREE.Vector3(0,0,0));if(global_VR){Devices=new THREE.DeviceOrientationControls(camera);Devices.connect();Devices.deviceOrientation=Devices.update()}document.addEventListener('touchmove',function(event){event.preventDefault();mouse.x=(event.touches[0].clientX/window.innerWidth)*2-1;mouse.y=-(event.touches[0].clientY/window.innerHeight)*2+1;raycaster.setFromCamera(mouse,camera)},false);document.addEventListener('touchstart',function(event){event.preventDefault();mouse.x=(event.touches[0].clientX/window.innerWidth)*2-1;mouse.y=-(event.touches[0].clientY/window.innerHeight)*2+1;raycaster.setFromCamera(mouse,camera);__render_event();_mouse_click(event)},false);document.addEventListener('touchend',_mouse_click,false)}}const block_size=5;const block_interval=2+block_size;

	var computer_material;

	function init_map() {
		var geometry=new THREE.BoxGeometry(block_size,block_size,block_size);var material=new THREE.MeshBasicMaterial({map:THREE.ImageUtils.loadTexture('img/timg.jpg'),color:0xffffff,wireframe:false,opacity:0.5});computer_material=new THREE.MeshBasicMaterial({map:THREE.ImageUtils.loadTexture('img/timg1.jpg'),color:0xffffff,wireframe:false,opacity:0.5});for(var y=0;y<9;y++){for(var x=0;x<9;x++){var cube1=new THREE.Mesh(geometry,material.clone());cube1.name=y*9+x;cube1.translateOnAxis(new THREE.Vector3(block_interval*(x-4),block_interval*(y-4),0),1);cube1.userData['used']=false;scene.add(cube1)}}var sphere=new THREE.Mesh(new THREE.SphereGeometry(block_size/2,32,32),new THREE.MeshPhongMaterial({color:0x00ff00,opacity:0.5}));sphere.name=global_qizi0;sphere.userData['on']=-1;scene.add(sphere);sphere=new THREE.Mesh(new THREE.SphereGeometry(block_size/2,32,32),new THREE.MeshPhongMaterial({color:0xff0000,opacity:0.5}));sphere.name=global_qizi1;sphere.userData['on']=-1;scene.add(sphere);_set_qizi(global_qizi0,4);_set_qizi(global_qizi1,67);var cube=new THREE.Mesh(new THREE.BoxGeometry(block_interval+block_size,block_interval-block_size,block_size+block_size),material.clone());cube.name=global_qiangh;scene.add(cube);_set_qiang(cube,-1);cube=new THREE.Mesh(new THREE.BoxGeometry(block_interval-block_size,block_interval+block_size,block_size+block_size),material.clone());cube.name=global_qiangs;scene.add(cube);_set_qiang(cube,-2);new THREE.FontLoader().load('fonts/SimHei_Regular.json',function(font){var text=new THREE.Mesh(new THREE.TextGeometry('删除',{size:block_size,height:block_interval-block_size,curveSegments:12,font:font}),new THREE.MeshPhongMaterial({color:0x00ff00}));text.translateOnAxis(new THREE.Vector3(2.5*block_size,-10.3*block_size,block_size).sub(text.position),1);text.name=global_delete;scene.add(text)})
	}

	function animate() {
		requestAnimationFrame(animate);_render();_update()
	}

	function _update() {
		var delta=clock.getDelta();if(global_is_pc){controls.update()}else if(global_VR){Devices.update()}
	}

	function _render() {
		renderer.render(scene,camera);__render_event()
	}

	function __render_event() {
		switch(mouse_state){case state_normal:case state_move:var intersects=raycaster.intersectObjects(scene.children);if(intersects.length>0){if(INTERSECTED!=intersects[0].object){if(INTERSECTED)if(_is_qipan_kong(INTERSECTED.name)&&mouse_state==state_move)INTERSECTED.material.transparent=false;INTERSECTED=intersects[0].object;if(_is_qipan_kong(INTERSECTED.name)&&mouse_state==state_move)INTERSECTED.material.transparent=true}}else{if(INTERSECTED)if(_is_qipan_kong(INTERSECTED.name)&&mouse_state==state_move)INTERSECTED.material.transparent=false;INTERSECTED=null}break;case state_qiang:scene.children[mouse_choose].translateOnAxis(__qiang_move(raycaster.ray.origin.sub(raycaster.ray.direction.multiplyScalar(raycaster.ray.origin.z*1.0/raycaster.ray.direction.z))).sub(scene.children[mouse_choose].position),1);break;case state_delete:var intersects=raycaster.intersectObjects(global_qianglist);if(intersects.length>0){if(INTERSECTED!=intersects[0].object){if(INTERSECTED)INTERSECTED.material.transparent=false;INTERSECTED=intersects[0].object;INTERSECTED.material.transparent=true}}else{if(INTERSECTED)INTERSECTED.material.transparent=false;INTERSECTED=null}break;default:}
	}

	function __qiang_move(postion){result=postion.clone();result.z=block_size/2.0;if(Math.abs(result.x)<block_interval*4&&Math.abs(result.y)<block_interval*4){result.x=(Math.floor(result.x/block_interval)+0.5)*block_interval;result.y=(Math.floor(result.y/block_interval)+0.5)*block_interval;bool_qiang=true}else bool_qiang=false;return result}

	function _set_qizi(qizi,qipan){qipan_y=Math.floor(qipan/9);qipan_x=qipan-qipan_y*9;var tmp=scene.children[qizi].userData['on'];if(tmp>-1)scene.children[tmp+global_qipan[0]].userData['used']=false;scene.children[qizi].translateOnAxis(new THREE.Vector3(block_interval*(qipan_x-4),block_interval*(qipan_y-4),block_size).sub(scene.children[qizi].position),1);scene.children[qizi].userData['on']=qipan;scene.children[qipan+global_qipan[0]].userData['used']=true}

	function _set_qiang(qiqiang,qipan){if(qipan==-1){qiqiang.translateOnAxis(new THREE.Vector3(-4*block_size,-10*block_size,block_size).sub(qiqiang.position),1)}else if(qipan==-2){qiqiang.translateOnAxis(new THREE.Vector3(0,-10*block_size,block_size).sub(qiqiang.position),1)}else if(qipan>-1&&qipan<64){qipan_y=Math.floor(qipan/8);qipan_x=qipan-qipan_y*8;qiqiang.material=computer_material.clone();qiqiang.translateOnAxis(new THREE.Vector3(block_interval*(qipan_x-3.5),block_interval*(qipan_y-3.5),block_size/2.0).sub(qiqiang.position),1)}}

	function _is_qizi(a) {
		return(a==global_qizi0||a==global_qizi1)
	}

	function _is_qipan_kong(a){if(a>-1&&a<global_qizi0)return!scene.children[a+global_qipan[0]].userData['used'];return false}

	function _is_qiang(a){return(a==global_qiangh||a==global_qiangs)}

	function _is_qiang_kong(obj){if(obj.userData['hs']==global_qiangh){for(var i=0;i<global_qianglist.length-1;i++){if(Math.abs(Math.round(global_qianglist[i].position.y-obj.position.y))<block_interval){if(Math.abs(Math.round(global_qianglist[i].position.x-obj.position.x))<block_interval||(Math.abs(Math.round(global_qianglist[i].position.x-obj.position.x))<2*block_interval&&obj.userData['hs']==global_qianglist[i].userData['hs']))return false}}}else if(obj.userData['hs']==global_qiangs){for(var i=0;i<global_qianglist.length-1;i++){if(Math.abs(Math.round(global_qianglist[i].position.x-obj.position.x))<block_interval){if(Math.abs(Math.round(global_qianglist[i].position.y-obj.position.y))<block_interval||(Math.abs(Math.round(global_qianglist[i].position.y-obj.position.y))<2*block_interval&&obj.userData['hs']==global_qianglist[i].userData['hs']))return false}}}else{console.error('userData[\'hs\'] unknow')}obj.userData['on']=[Math.round((obj.position.x-3.5)/ 7) + 4, Math.round((obj.position.y - 3.5) /7)+4];return true}

	function _is_delete(a){return false}const state_normal=0;const state_move=1;const state_qiang=2;const state_delete=3;var mouse_state=state_normal;var mouse_choose=null;var bool_qiang=false;

	function _mouse_click(event){if(!turn_peson)return;switch(mouse_state){case state_normal:if(INTERSECTED!=null){if(INTERSECTED.name==global_qizi0){INTERSECTED.material.transparent=true;mouse_choose=INTERSECTED.name;mouse_state=state_move}else if(_is_qiang(INTERSECTED.name)){var obj=new THREE.Mesh(INTERSECTED.geometry,INTERSECTED.material.clone()).copy(INTERSECTED);obj.material.transparent=true;obj.name=scene.children.length;mouse_choose=obj.name;obj.userData['hs']=INTERSECTED.name;scene.add(obj);global_qianglist.push(obj);bool_qiang=false;mouse_state=state_qiang}else if(_is_delete(INTERSECTED.name)){INTERSECTED.material.color.set(0xff0000);mouse_state=state_delete}}break;case state_move:if(INTERSECTED!=null&&_is_qipan_kong(INTERSECTED.name)&&_move_qizi(mouse_choose).indexOf(INTERSECTED.name)>-1){_set_qizi(mouse_choose,INTERSECTED.name);turn_peson=false;scene.children[mouse_choose].material.transparent=false;INTERSECTED.material.transparent=false;mouse_choose=null;mouse_state=state_normal}else{scene.children[mouse_choose].material.transparent=false;if(INTERSECTED!=null)INTERSECTED.material.transparent=false;mouse_choose=null;mouse_state=state_normal}break;case state_qiang:if(bool_qiang&&_is_qiang_kong(scene.children[mouse_choose])&&_step_cal(global_qizi0).success&&_step_cal(global_qizi1).success&&qiang0>0){turn_peson=false;scene.children[mouse_choose].material.transparent=false;mouse_choose=null;mouse_state=state_normal;qiang0--}else{list_rm(global_qianglist,scene.children[mouse_choose]);list_rm(scene.children,scene.children[mouse_choose]);mouse_state=state_normal}break;case state_delete:if(INTERSECTED!=null){list_rm(global_qianglist,INTERSECTED);list_rm(scene.children,INTERSECTED)}scene.children[global_delete].material.color.set(0x00ff00);mouse_state=state_normal;break;default:}if(winner()){alert("玩家胜利");window.location.reload();return}if(!turn_peson){computer_go();if(winner()){alert("电脑胜利");window.location.reload();return}}}

	function winner() {
		if(scene.children[global_qizi0].userData['on']>71)return true;if(scene.children[global_qizi1].userData['on']<9)return true
	}

	function computer_set_qiang(qipan,hs,commit){var obj=null;if(hs){obj=new THREE.Mesh(scene.children[global_qiangh].geometry,computer_material.clone()).copy(scene.children[global_qiangh]);obj.userData['hs']=global_qiangh}else{obj=new THREE.Mesh(scene.children[global_qiangs].geometry,computer_material.clone()).copy(scene.children[global_qiangs]);obj.userData['hs']=global_qiangs}obj.userData['on']=[qipan%8,Math.floor(qipan/8)];obj.name=scene.children.length;global_qianglist.push(obj);_set_qiang(obj,qipan);if(commit){scene.add(obj);return obj}else return obj}

	function computer_go(){var currentPostion=scene.children[global_qizi1].userData['on'];var obj=null;var re0=0;var re1=0;var qiang_set=[-1,true];var qizi_set=-1;var currentvalue=_step_cal(global_qizi0).max_step-_step_cal(global_qizi1).max_step;var value=-100;var value1=-100;if(qiang1>0){for(var i=0;i<64;i++){obj=computer_set_qiang(i,true);re0=_step_cal(global_qizi0);re1=_step_cal(global_qizi1);if(value<(re0.max_step-re1.max_step)&&re0.success&&re1.success&&_is_qiang_kong(obj)){value=re0.max_step-re1.max_step;qiang_set=[i,true]}global_qianglist.pop();obj=computer_set_qiang(i,false);re0=_step_cal(global_qizi0);re1=_step_cal(global_qizi1);if(value<(re0.max_step-re1.max_step)&&re0.success&&re1.success&&_is_qiang_kong(obj)){value=re0.max_step-re1.max_step;qiang_set=[i,false]}global_qianglist.pop()}}var result=_move_qizi(global_qizi1);for(var i in result){_set_qizi(global_qizi1,result[i]);re0=_step_cal(global_qizi0);re1=_step_cal(global_qizi1);if(value1<(re0.max_step-re1.max_step)){value1=re0.max_step-re1.max_step;qizi_set=result[i]}}_set_qizi(global_qizi1,currentPostion);if((value1>0&&value1+currentvalue+2>value)||qiang1==0){_set_qizi(global_qizi1,qizi_set)}else{computer_set_qiang(qiang_set[0],qiang_set[1],true);qiang1--}turn_peson=true}

	function _move_qizi(qizi,position){result=[];if(position==null){position=scene.children[qizi].userData['on']}else if(position<0||position>80){console.error("position need in [0,80]");return[]}var qizi1=(qizi==global_qizi0)?global_qizi1:global_qizi0;result=__get_neighbour_point(position);var i=result.indexOf(scene.children[qizi1].userData['on']);if(i>-1){var re=__get_neighbour_point(result[i]);re.splice(re.indexOf(position),1);result.splice(i,1);result=result.concat(re)}return result}

	function __get_neighbour_point(point){var result=[];var forward=[true,true,true,true];var p=-1;for(var i in global_qianglist){p=global_qianglist[i].userData['on'];if(global_qianglist[i].userData['hs']==global_qiangh){switch(point){case p[1]*9+p[0]:case p[1]*9+p[0]+1:forward[0]=false;break;case(p[1]+1)*9+p[0]:case(p[1]+1)*9+p[0]+1:forward[1]=false;break}}else if(global_qianglist[i].userData['hs']==global_qiangs){switch(point){case(p[1]+1)*9+p[0]+1:case p[1]*9+p[0]+1:forward[2]=false;break;case(p[1]+1)*9+p[0]:case p[1]*9+p[0]:forward[3]=false;break}}}if(point<72&&forward[0])result.push(point+9);if(point>8&&forward[1])result.push(point-9);if(point%9&&forward[2])result.push(point-1);if(point%9!=8&&forward[3])result.push(point+1);return result}

	function _step_cal(qizi){var list0=[scene.children[qizi].userData['on']];var list1=list0;var list2;var result={};var len=0;var step=0;var index=0;var success=false;var end_condition=[0,0];if(qizi==global_qizi0){end_condition=[71,81]}else if(qizi==global_qizi1){end_condition=[-1,9]}while(len<list0.length){list2=[];len=list0.length;step++;for(var i in list1){var re=_move_qizi(qizi,list1[i]);for(var j in re){if(list0.indexOf(re[j])==-1){list0.push(re[j]);list2.push(re[j]);result[re[j]]={'step':step,'parent':list1[i]};if(re[j]>end_condition[0]&&re[j]<end_condition[1]){index=re[j];success=true;len=1000}}}}list1=list2}return{'result':result,'max_step':step,'max_index':index,'success':success}}	
