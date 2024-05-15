import { defineStore } from 'pinia';

export const useAreaStore = defineStore('area', () => {
  const breweryAreaList = [
    { name: 'gyeonggi', title: '경기' },
    { name: 'incheon', title: '인천' },
    { name: 'gangwon', title: '강원' },
    { name: 'chungcheong', title: '충청' },
    { name: 'jeolla', title: '전라' },
    { name: 'gyeongsang', title: '경상' },
    { name: 'jeju', title: '제주' },
  ];
  const areas = {
    seoul: [
      {
        name: '강남구',
        link: 'https://visitgangnam.net/',
      },
      {
        name: '강동구',
        link: 'https://www.gangdong.go.kr/culture/',
      },
      {
        name: '강북구',
        link: 'https://www.gangbuk.go.kr/tour/index.do',
      },
      {
        name: '강서구',
        link: 'https://www.gangseo.seoul.kr/munhwa/index',
      },
      {
        name: '관악구',
        link: 'https://www.gwanak.go.kr/site/gwanak/area/areaMain.do?cateCont=Area02',
      },
      {
        name: '광진구',
        link: 'https://www.gwangjin.go.kr/portal/main/contents.do?menuNo=200241',
      },
      {
        name: '구로구',
        link: 'https://www.guro.go.kr/www/selectBbsNttList.do?bbsNo=668&key=1796&',
      },
      {
        name: '금천구',
        link: 'https://www.geumcheon.go.kr/portal/contents.do?key=954',
      },
      {
        name: '노원구',
        link: 'https://www.nowon.kr/www/info/info1/info1_01.jsp',
      },
      {
        name: '도봉구',
        link: 'https://tour.dobong.go.kr/',
      },
      {
        name: '동대문구',
        link: 'https://www.ddm.go.kr/tour/index.do',
      },
      {
        name: '동작구',
        link: 'https://www.dongjak.go.kr/portal/main/contents.do?menuNo=201107',
      },
      {
        name: '마포구',
        link: 'https://www.mapo.go.kr/site/culture/home',
      },
      {
        name: '서대문구',
        link: 'https://www.sdm.go.kr/culture/index.do',
      },
      {
        name: '서초구',
        link: 'https://culture.seocho.go.kr/',
      },
      {
        name: '성동구',
        link: 'https://www.sd.go.kr/tour/index.do',
      },
      {
        name: '성북구',
        link: 'https://www.sb.go.kr/tour/mainPage.do',
      },
      {
        name: '송파구',
        link: 'https://www.songpa.go.kr/culture/index.do',
      },
      {
        name: '양천구',
        link: 'https://www.yangcheon.go.kr/site/yangcheon/ex/bbs/List.do?cbIdx=354',
      },
      {
        name: '영등포구',
        link: 'https://www.ydp.go.kr/tour/index.do',
      },
      {
        name: '용산구',
        link: 'https://www.yongsan.go.kr/portal/main/main.do',
      },
      {
        name: '은평구',
        link: 'https://eptour.kr/',
      },
      {
        name: '종로구',
        link: 'https://tour.jongno.go.kr/tourMain.do',
      },
      {
        name: '중구구',
        link: 'https://www.junggu.seoul.kr/tour/',
      },
      {
        name: '중랑구',
        link: 'https://www.jungnang.go.kr/portal/main/contents.do?menuNo=200371',
      },
    ],
    incheon: [
      { name: '강화군', link: 'https://www.ganghwa.go.kr/open_content/tour/' },
      { name: '계양구', link: 'https://www.gyeyang.go.kr/open_content/tour/' },
      { name: '미추훌구', link: 'https://www.michuhol.go.kr/culture/main.do' },
      { name: '남동구', link: 'https://www.namdong.go.kr/main/' },
      { name: '동구', link: 'https://www.icdonggu.go.kr/tour/' },
      { name: '부평구', link: 'https://www.icbp.go.kr/tour/' },
      { name: '서구', link: 'https://www.seo.incheon.kr/open_content/tour/' },
      { name: '연수구', link: 'https://www.yeonsu.go.kr/tour/' },
      { name: '옹진군', link: 'https://www.ongjin.go.kr/open_content/tour/' },
      { name: '중구', link: 'https://www.icjg.go.kr/tour/index' },
    ],
    deajeon: [
      {
        name: '대덕구',
        link: 'https://www.daedeok.go.kr/tour/index.do',
      },
      {
        name: '동구',
        link: 'https://www.donggu.go.kr/dg/tour',
      },
      {
        name: '서구',
        link: 'https://www.seogu.go.kr/tour/index.do',
      },
      {
        name: '유성구',
        link: 'https://www.yuseong.go.kr/tour/',
      },
      {
        name: '중구',
        link: 'https://www.djjunggu.go.kr/tour/index.do',
      },
    ],
    deagu: [
      {
        name: '남구',
        link: 'https://www.nam.daegu.kr/tour/index.do',
      },
      {
        name: '달서구',
        link: 'https://www.dalseo.daegu.kr/tour/index.do',
      },
      {
        name: '달성군',
        link: 'https://www.dalseong.daegu.kr/culture/index.do',
      },
      {
        name: '동구',
        link: 'https://dong.daegu.kr/main.do',
      },
      {
        name: '북구',
        link: 'https://daegubukgu.noblapp.com/',
      },
      {
        name: '서구',
        link: 'https://www.dgs.go.kr/tour/',
      },
      {
        name: '수성구',
        link: 'https://www.suseong.kr/tour/index.do',
      },
      {
        name: '중구',
        link: 'https://www.jung.daegu.kr/new/culture/pages/main/',
      },
      {
        name: '군위군',
        link: 'https://www.gunwi.go.kr/tour/main.do',
      },
    ],
    gyeonggi: [
      {
        name: '수원시',
        link: 'https://www.suwon.go.kr/web/visitsuwon/index.do',
      },
      {
        name: '성남시',
        link: 'https://www.seongnam.go.kr/tour',
      },
      {
        name: '의정부시',
        link: 'https://www.ui4u.go.kr/tour/main.do',
      },
      {
        name: '안양시',
        link: 'https://www.anyang.go.kr/tour/index.do',
      },
      {
        name: '부천시',
        link: 'https://www.bucheon.go.kr/site/homepage/menu/viewMenu?menuid=148006001001001',
      },
      {
        name: '광명시',
        link: 'https://www.gm.go.kr/tr/index.do',
      },
      {
        name: '평택시',
        link: 'https://www.pyeongtaek.go.kr/tour/main.do',
      },
      {
        name: '동두천시',
        link: 'https://www.ddc.go.kr/tour/index.do',
      },
      {
        name: '안산시',
        link: 'https://www.ansan.go.kr/tourinfo/',
      },
      {
        name: '고양시',
        link: 'https://www.goyang.go.kr/visitgoyang/www/index.do',
      },
      {
        name: '과천시',
        link: 'https://www.gccity.go.kr/dept/contents.do?mId=0801010000',
      },
      {
        name: '구리시',
        link: 'https://www.guri.go.kr/culture/index.do',
      },
      {
        name: '남양주시',
        link: 'https://www.nyj.go.kr/culture/index.do',
      },
      {
        name: '오산시',
        link: 'https://www.osan.go.kr/depart/contents.do?mId=0910050100',
      },
      {
        name: '시흥시',
        link: 'https://www.siheung.go.kr/main.do',
      },
      {
        name: '군포시',
        link: 'https://www.gunpo.go.kr/tour/index.do',
      },
      {
        name: '의왕시',
        link: 'https://blog.naver.com/yesuw21',
      },
      {
        name: '하남시',
        link: 'https://www.hanam.go.kr/www/index.do',
      },
      {
        name: '용인시',
        link: 'https://www.yongin.go.kr/yitour/index.do',
      },
      {
        name: '파주시',
        link: 'https://tour.paju.go.kr/user/tour/main/index.do',
      },
      {
        name: '이천시',
        link: 'https://www.icheon.go.kr/tour/main.do',
      },
      {
        name: '안성시',
        link: 'https://www.anseong.go.kr/tour/main.do',
      },
      {
        name: '김포시',
        link: 'https://www.gimpo.go.kr/culture/index.do',
      },
      {
        name: '화성시',
        link: 'https://tour.hscity.go.kr/NEW/0index/index.jsp',
      },
      {
        name: '광주시',
        link: 'https://www.gjcity.go.kr/tour/main.do',
      },
      {
        name: '양주시',
        link: 'https://www.yangju.go.kr/tour/index.do',
      },
      {
        name: '포천시',
        link: 'https://www.pocheon.go.kr/ktour/index.do',
      },
      {
        name: '여주시',
        link: 'https://www.yjcf.or.kr/yjcf',
      },
      {
        name: '연천군',
        link: 'https://www.yeoncheon.go.kr/tour/index.do',
      },
      {
        name: '가평군',
        link: 'https://www.gptour.go.kr/',
      },
      {
        name: '양평군',
        link: 'https://tour.yp21.go.kr/www/index.do',
      },
    ],
    busan: [
      {
        name: '중구',
        link: 'https://www.bsjunggu.go.kr/tour/index.junggu',
      },
      {
        name: '서구',
        link: 'https://www.bsseogu.go.kr/tour/index.bsseogu',
      },
      {
        name: '동구',
        link: 'https://www.bsdonggu.go.kr/tour/index.donggu',
      },
      {
        name: '영도구',
        link: 'https://www.yeongdo.go.kr/tour.web',
      },
      {
        name: '부산진구',
        link: 'https://www.busanjin.go.kr/tour/index.busanjin?cpath=',
      },
      {
        name: '동래구',
        link: 'https://www.dongnae.go.kr/tour/index.dongnae?cpath=',
      },
      {
        name: '남구',
        link: 'https://www.bsnamgu.go.kr/index.namgu?menuCd=DOM_000000116000000000',
      },
      {
        name: '북구',
        link: 'https://www.bsbukgu.go.kr/tour/index.bsbukgu',
      },
      {
        name: '해운대구',
        link: 'https://www.haeundae.go.kr/tour/index.do',
      },
      {
        name: '사하구',
        link: 'https://tour.saha.go.kr/main.do',
      },
      {
        name: '금정구',
        link: 'https://www.geumjeong.go.kr/tour/index.geumj',
      },
      {
        name: '강서구',
        link: 'https://www.bsgangseo.go.kr/visit/main.do',
      },
      {
        name: '연제구',
        link: 'https://culture.yeonje.go.kr/main.do',
      },
      {
        name: '수영구',
        link: 'https://www.suyeong.go.kr/tour/index.suyeong',
      },
      {
        name: '사상구',
        link: 'https://www.sasang.go.kr/tour/index.sasang',
      },
      {
        name: '기장군',
        link: 'https://www.gijang.go.kr/tour/index.gijang',
      },
    ],
    ulsan: [
      {
        name: '중구',
        link: 'https://www.junggu.ulsan.kr/tour/index.ulsan',
      },
      {
        name: '남구',
        link: 'https://www.ulsannamgu.go.kr/tour/main.do',
      },
      {
        name: '동구',
        link: 'https://www.donggu.ulsan.kr/tour/cmm/main/mainPage.do',
      },
      {
        name: '북구',
        link: 'https://www.bukgu.ulsan.kr/lay1/S1T203C306/contents.do',
      },
      {
        name: '울주군',
        link: 'https://www.ulju.ulsan.kr/tour/main.do',
      },
    ],
    gwangju: [
      {
        name: '동구',
        link: 'https://www.donggu.kr/index.es?sid=a1',
      },
      {
        name: '서구',
        link: 'https://blog.naver.com/gwangjuseogu',
      },
      {
        name: '북구',
        link: 'https://bukgu.gwangju.kr/culture/',
      },
      {
        name: '광산구',
        link: 'https://www.gwangsan.go.kr/culture/',
      },
      {
        name: '남구',
        link: 'https://www.namgu.gwangju.kr/index.es?sid=a7',
      },
    ],
    gangwon: [
      {
        name: '춘천시',
        link: 'http://tour.chuncheon.go.kr/',
      },
      {
        name: '원주시',
        link: 'https://www.wonju.go.kr/tour/index.do',
      },
      {
        name: '강릉시',
        link: 'https://www.gn.go.kr/tour/index.do',
      },
      {
        name: '동해시',
        link: 'https://www.dh.go.kr/tour/index.do',
      },
      {
        name: '태백시',
        link: 'https://tour.taebaek.go.kr/tour',
      },
      {
        name: '속초시',
        link: 'https://www.sokchotour.com/tour',
      },
      {
        name: '삼척시',
        link: 'https://tour.samcheok.go.kr/portal/intro/intro.jsp',
      },
      {
        name: '홍천군',
        link: 'https://www.hongcheon.go.kr/tour/index.do',
      },
      {
        name: '횡성군',
        link: 'https://www.hsg.go.kr/tour/index.do',
      },
      {
        name: '영월군',
        link: 'https://www.yw.go.kr/tour/index.do',
      },
      {
        name: '평창군',
        link: 'https://tour.pc.go.kr/Home/index',
      },
      {
        name: '정선군',
        link: 'https://www.jeongseon.go.kr/tour/jeongseontour/attractions',
      },
      {
        name: '철원군',
        link: 'https://www.cwg.go.kr/tour/index.do',
      },
      {
        name: '화천군',
        link: 'https://tour.ihc.go.kr/',
      },
      {
        name: '양구군',
        link: 'https://www.ygtour.kr/Home/index',
      },
      {
        name: '인제군',
        link: 'https://tour.inje.go.kr/tour',
      },
      {
        name: '고성군',
        link: 'https://www.gwgs.go.kr/tour/index.do',
      },
      {
        name: '양양군',
        link: 'https://tour.yangyang.go.kr/',
      },
    ],
    jeju: [
      {
        name: '제주시',
        link: 'https://www.visitjeju.net/kr',
      },
      {
        name: '서귀포시',
        link: 'https://www.seogwipo.go.kr/field/tourist.htm',
      },
    ],
  };
  return { areas, breweryAreaList };
});
