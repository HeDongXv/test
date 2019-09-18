package com.orilore.db;

import java.util.List;



import org.apache.ibatis.session.SqlSession;

import com.orilore.mapper.NodeMapper;
import com.orilore.mapper.RoleMapper;
import com.orilore.model.Node;
import com.orilore.model.Role;

public class Test2 {

	public static void main(String[] args) {
		SqlSession session = DBUtil.getSession();
		RoleMapper mapper = session.getMapper(RoleMapper.class);
		NodeMapper nm = session.getMapper(NodeMapper.class);
		
		List<Node> node = nm.select();
		if(node!=null) {
			for(Node n : node) {
				System.out.println(n.getName());
				System.out.print("获得权限的人：");
				List<Role> roles = n.getRoles();
				if(roles!=null) {
					for(Role r : roles) {
						System.out.print(r.getName());
					}
					System.out.println("");
				}
			}
		}
		
//		Role role = mapper.selectOne(3);
//		System.out.println(role.getName());
//		System.out.println("-------------");
//		List<Node> nodes = role.getNodes();
//		for(Node n : nodes) {
//			System.out.println(n.getName()+"\t"+n.getUrl());
//		}
	}

}
