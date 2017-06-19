/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BLL.ChiTietHoaDonBLL;
import java.util.Date;
import BLL.HoaDonBLL;
import BLL.LoginBLL;
import BLL.ThucDonBLL;
import DAL.BanDAL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import org.netbeans.lib.awtextra.*;
import DTO.*;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LTSNLH5586
 */
public class frmHome extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    public static int selectBan = 0;
    public static int trangThaiBan = 0;
    public static String tenBan = "";
    public static String soHoaDon = "";
    public static int idChiTietHoaDon = 0;
    public static int idThucDon = 0;
    public static int soLuong = 0;

    /**
     * Creates new form frmHome
     */
    public frmHome() {
        initComponents();

        FillBan();

    }

    public void a() {
        pnlGroupBan.updateUI();
    }

    public void FillBan() {
        pnlGroupBan.removeAll();
        lblTrangThai.setText("");
        lblGioDen.setText("");
        lblTongTien.setText("");
        DefaultTableModel dtm = (DefaultTableModel) tblGoiMon.getModel();
        dtm.setRowCount(0);

        ArrayList<Ban> ban = BanDAL.getAllBan();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlBan = new JPanel[ban.size()];
        JLabel[] lblImgBan = new JLabel[ban.size()];
        JLabel[] lblTenBan = new JLabel[ban.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < ban.size(); i++) {
            checkclick.add(i, false);
            pnlBan[i] = new javax.swing.JPanel();
            lblImgBan[i] = new javax.swing.JLabel();
            lblTenBan[i] = new javax.swing.JLabel();
            switch (ban.get(i).getTrangthai()) {
                case 1:
                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px.png"))); // NOI18N
                    break;
                case 2:
                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px_2.png"))); // NOI18N
                    break;
                case 3:
                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px_3.png"))); // NOI18N
                    break;
                default:
                    break;
            }
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTenBan[i].setText(ban.get(i).getTenban());

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(21, Short.MAX_VALUE))
            );
            pnlBanLayout.setVerticalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblImgBan[i])
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTenBan[i])
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            int j = i;
            pnlBan[i].addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    if (trangThaiBan == 1) {
                        lblDatBan.setText("Đặt Bàn");
                    } else if (trangThaiBan == 2) {
                        lblDatBan.setText("Hủy Đặt Bàn");
                    }
                    if (checkclick.get(j)) {
                        checkclick.set(j, false);
                        selectBan = 0;
                        trangThaiBan = 0;
                        tenBan = "";
                        soHoaDon = "";
                        e.getComponent().setBackground(Color.yellow);
                        //  System.out.println(selectBan + trangThaiBan + tenBan + soHoaDon);
                    } else {
                        checkclick.set(j, true);
                        selectBan = ban.get(j).getId();
                        trangThaiBan = ban.get(j).getTrangthai();
                        tenBan = ban.get(j).getTenban();
                        soHoaDon = ban.get(j).getSoHoaDon();
                        // System.out.println(selectBan + trangThaiBan + tenBan + soHoaDon);
                        for (int k = 0; k < ban.size(); k++) {
                            if (k != j) {
                                checkclick.set(k, false);
                                pnlBan[k].setBackground(new java.awt.Color(240, 240, 240));
                            }

                        }

                    }

                    //System.out.println(soHoaDon);
                    HoaDon hoaDon = HoaDonBLL.getHoaDonBySoHoaDon(ban.get(j).getSoHoaDon());
                    DefaultTableModel dtm = (DefaultTableModel) tblGoiMon.getModel();
                    switch (ban.get(j).getTrangthai()) {
                        case 1:
                            lblTrangThai.setText("Bàn Trống");
                            lblTrangThai.setForeground(Color.GREEN);
                            lblGioDen.setText("");
                            lblTongTien.setText("");

                            dtm.setRowCount(0);

                            break;
                        case 2:
                            lblTrangThai.setText("Đang Đặt Chỗ");
                            lblTrangThai.setForeground(Color.ORANGE);
                            lblGioDen.setText(hoaDon.getGioden());
                            lblTongTien.setText("");

                            dtm.setRowCount(0);
                            break;
                        case 3:
                            lblTrangThai.setText("Đang Phục Vụ");
                            lblTrangThai.setForeground(Color.RED);
                            lblGioDen.setText(hoaDon.getGioden());
                            lblTongTien.setText(hoaDon.getTongtien().toString());
                            //ResultSet rsGetAllThucDon = ThucDonBLL.getAllThucDon();
                            //ThucDonBLL.doDuLieuVaoBang(rsGetAllThucDon, tblGoiMon);
                            ResultSet rsGetChiTietThucDonBySoHoaDon = ChiTietHoaDonBLL.getChiTietThucDonBySoHoaDon(soHoaDon);
                            ChiTietHoaDonBLL.DoDuLieuVaoJTableChiTietHoaDon(rsGetChiTietThucDonBySoHoaDon, tblGoiMon);
                            break;
                        default:
                            break;
                    }

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    e.getComponent().setBackground(Color.yellow);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (checkclick.get(j)) {
                        e.getComponent().setBackground(Color.yellow);
                    } else {

                        e.getComponent().setBackground(new java.awt.Color(240, 240, 240));
                    }
                }

                @Override
                public void mouseClicked(MouseEvent e) {

                }

            });

            pnlGroupBan.add(pnlBan[i]);
        }
        pnlGroupBan.updateUI();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlGroupBan = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGoiMon = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        lblGioDen = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblIconDatBan = new javax.swing.JLabel();
        lblDatBan = new javax.swing.JLabel();
        lblIconOrder = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        lblIconThanhToan = new javax.swing.JLabel();
        lblThanhToan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jlbIconBan = new javax.swing.JLabel();
        jlbBan = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();

        jPopupMenu1.setBackground(new java.awt.Color(238, 253, 221));

        jMenuItem1.setBackground(new java.awt.Color(251, 198, 174));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit Property_25px.png"))); // NOI18N
        jMenuItem1.setText("Edit");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jSeparator1);

        jMenuItem2.setBackground(new java.awt.Color(249, 178, 179));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete Property_25px.png"))); // NOI18N
        jMenuItem2.setText("Delete");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(85, 78, 59));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(63, 0, 4), null, null));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Multiply_20px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(212, 216, 225));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(212, 216, 225));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cafe_20px_1.png"))); // NOI18N
        jLabel5.setText("Phần Mềm Quản Lý Quán Cafe");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Minus_20px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 950, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 30));

        jPanel2.setBackground(new java.awt.Color(214, 186, 155));

        pnlGroupBan.setBackground(new java.awt.Color(255, 255, 255));

        tblGoiMon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "SoHoaDon", "Tên Món", "Số Lượng", "Giá", "Tổng Giá"
            }
        ));
        tblGoiMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGoiMonMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblGoiMonMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblGoiMon);
        if (tblGoiMon.getColumnModel().getColumnCount() > 0) {
            tblGoiMon.getColumnModel().getColumn(0).setMinWidth(0);
            tblGoiMon.getColumnModel().getColumn(0).setMaxWidth(0);
            tblGoiMon.getColumnModel().getColumn(1).setMinWidth(0);
            tblGoiMon.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Giờ Đến : ");

        lblGioDen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblGioDen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGioDen.setText("7h");

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Tổng Tiền : ");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 0, 0));
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongTien.setText("200.000");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Trạng Thái :");

        lblTrangThai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrangThai.setText("Trống");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGioDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(lblTrangThai))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(lblGioDen))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(lblTongTien))
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(220, 234, 205));

        lblIconDatBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List_40px.png"))); // NOI18N
        lblIconDatBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblIconDatBanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIconDatBanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblIconDatBanMousePressed(evt);
            }
        });

        lblDatBan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDatBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatBan.setText("Đặt Bàn");

        lblIconOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Todo List_40px.png"))); // NOI18N
        lblIconOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblIconOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIconOrderMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblIconOrderMousePressed(evt);
            }
        });

        lblOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrder.setText("Order");

        lblIconThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cash Register_40px.png"))); // NOI18N
        lblIconThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblIconThanhToanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIconThanhToanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblIconThanhToanMousePressed(evt);
            }
        });

        lblThanhToan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThanhToan.setText("Thanh Toán");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(lblIconDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblIconThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblThanhToan))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblIconDatBan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDatBan))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblIconOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblOrder)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGroupBan, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlGroupBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1240, 570));

        jPanel3.setBackground(new java.awt.Color(248, 255, 229));

        jPanel7.setBackground(new java.awt.Color(255, 231, 220));

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Menu_50px.png"))); // NOI18N
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel91MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel91MouseExited(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Thực Đơn");

        jlbIconBan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbIconBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbIconBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Table_52px.png"))); // NOI18N
        jlbIconBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbIconBanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbIconBanMouseExited(evt);
            }
        });

        jlbBan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlbBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbBan.setText("Bàn");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlbBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbIconBan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jlbIconBan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbBan))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel92)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 180, 187));

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Truck_48px.png"))); // NOI18N
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel89MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel89MouseExited(evt);
            }
        });

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("Nhập Hàng");

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shopping Cart Loaded_48px.png"))); // NOI18N
        jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel93MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel93MouseExited(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Hàng Hóa");

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shop_48px.png"))); // NOI18N
        jLabel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel95MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel95MouseExited(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("NCC");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel96))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel94))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel90)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(252, 228, 199));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/User_48px.png"))); // NOI18N
        jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel99MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel99MouseExited(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("Tài Khoản");

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add Rule_48px.png"))); // NOI18N
        jLabel101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel101MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel101MouseExited(evt);
            }
        });

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("Khen - Thưởng");

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Calculator_40px.png"))); // NOI18N
        jLabel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel103MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel103MouseExited(evt);
            }
        });

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("Lương");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel104))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel102))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel100))))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Rounded_48px.png"))); // NOI18N
        jLabel105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel105MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel105MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel105MousePressed(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("Đăng Xuất");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel106)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1250, 100));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        setState(ICONIFIED);

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jLabel91MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseEntered
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Menu_50px_1.png")));
        jLabel92.setFont(new Font("Tahoma", Font.BOLD, 12));


    }//GEN-LAST:event_jLabel91MouseEntered

    private void jLabel91MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseExited
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Menu_50px.png")));

        jLabel92.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jLabel91MouseExited

    private void jlbIconBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbIconBanMouseEntered
        jlbIconBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Table_52px_1.png")));
        jlbBan.setFont(new Font("Tahoma", Font.BOLD, 12));
    }//GEN-LAST:event_jlbIconBanMouseEntered

    private void jlbIconBanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbIconBanMouseExited
        jlbIconBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Table_52px.png")));
        jlbBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jlbIconBanMouseExited

    private void jLabel89MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseEntered
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Truck_40px_1.png")));
        jLabel90.setFont(new Font("Tahoma", Font.BOLD, 12));
    }//GEN-LAST:event_jLabel89MouseEntered

    private void jLabel89MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseExited
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Truck_48px.png")));
        jLabel90.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jLabel89MouseExited

    private void jLabel93MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseEntered
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shopping Cart_40px.png")));
        jLabel94.setFont(new Font("Tahoma", Font.BOLD, 12));
    }//GEN-LAST:event_jLabel93MouseEntered

    private void jLabel93MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseExited
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shopping Cart Loaded_48px.png")));
        jLabel94.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jLabel93MouseExited

    private void jLabel95MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseEntered
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shop_40px.png")));
        jLabel96.setFont(new Font("Tahoma", Font.BOLD, 12));
    }//GEN-LAST:event_jLabel95MouseEntered

    private void jLabel95MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseExited
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Shop_48px.png")));
        jLabel96.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jLabel95MouseExited

    private void jLabel99MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseEntered
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Female User_40px.png")));
        jLabel100.setFont(new Font("Tahoma", Font.BOLD, 12));
    }//GEN-LAST:event_jLabel99MouseEntered

    private void jLabel99MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseExited
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/User_48px.png")));
        jLabel100.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jLabel99MouseExited

    private void jLabel101MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseEntered
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rules_40px.png")));
        jLabel102.setFont(new Font("Tahoma", Font.BOLD, 12));
    }//GEN-LAST:event_jLabel101MouseEntered

    private void jLabel101MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseExited
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add Rule_48px.png")));
        jLabel102.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jLabel101MouseExited

    private void jLabel103MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseEntered
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Calculator_48px.png")));
        jLabel104.setFont(new Font("Tahoma", Font.BOLD, 12));
    }//GEN-LAST:event_jLabel103MouseEntered

    private void jLabel103MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseExited
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Calculator_40px.png")));
        jLabel104.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_jLabel103MouseExited

    private void jLabel105MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseEntered
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Rounded_48px_1.png")));
        jLabel106.setForeground(Color.RED);
    }//GEN-LAST:event_jLabel105MouseEntered

    private void jLabel105MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MouseExited
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logout Rounded_48px.png")));
        jLabel106.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel105MouseExited

    private void lblIconDatBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconDatBanMouseEntered

        if (trangThaiBan == 1) {
            lblIconDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List_40px_1.png")));
            lblDatBan.setFont(new Font("Tahoma", Font.BOLD, 12));
        } else if (trangThaiBan == 2) {
            lblIconDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List_40px_1.png")));

            lblDatBan.setFont(new Font("Tahoma", Font.BOLD, 12));
        }
    }//GEN-LAST:event_lblIconDatBanMouseEntered

    private void lblIconDatBanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconDatBanMouseExited
        lblIconDatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List_40px.png")));
        lblDatBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_lblIconDatBanMouseExited

    private void lblIconOrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconOrderMouseEntered
        if (selectBan != 0) {
            lblIconOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Todo List_40px_1.png")));
            lblOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
        }

    }//GEN-LAST:event_lblIconOrderMouseEntered

    private void lblIconOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconOrderMouseExited
        lblIconOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Todo List_40px.png")));
        lblOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_lblIconOrderMouseExited

    private void lblIconThanhToanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconThanhToanMouseEntered
        if (trangThaiBan == 3 && selectBan != 0) {
            lblIconThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cash Register_40px_1.png")));

        }
        // jLabel9.setForeground(Color.GREEN);
    }//GEN-LAST:event_lblIconThanhToanMouseEntered

    private void lblIconThanhToanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconThanhToanMouseExited
        lblIconThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cash Register_40px.png")));
        // jLabel9.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblIconThanhToanMouseExited

    private void lblIconDatBanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconDatBanMousePressed
        if (trangThaiBan == 1) {
//            BanDAL.updateTrangThaiVaSoHoaDon(selectBan, null, 2);
//            DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//            LocalDateTime now = LocalDateTime.now();
//            String gioDen = dtf.format(now);
//            String createSoHoaDon = dtf1.format(now);
//            HoaDon hd = new HoaDon(createSoHoaDon, gioDen, new BigDecimal(0), new BigDecimal(0), LoginBLL.manv, 0, selectBan);
//            HoaDonBLL.addHoaDon(hd);
            jdGioDen jdGioDen = new jdGioDen(this, true);
            jdGioDen.setVisible(true);
        } else if (trangThaiBan == 2) {
            //BanDAL.updateTrangThaiVaSoHoaDon(selectBan, null, 1);
            int kq = JOptionPane.showConfirmDialog(null, "Bạn Muốn Hủy Đặt Bàn : " + tenBan + " ?", "Phần Mềm Quản Lý Quán Cafe", JOptionPane.YES_NO_OPTION);
            if (kq == 0) {
                HoaDonBLL.deleteHoaDon(soHoaDon);
                BanDAL.updateTrangThaiVaSoHoaDon(selectBan, null, 1);
            }
            FillBan();
        }
        pnlGroupBan.removeAll();
        FillBan();
        pnlGroupBan.updateUI();
    }//GEN-LAST:event_lblIconDatBanMousePressed

    private void lblIconOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconOrderMousePressed
        if (selectBan != 0) {

//            DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//            LocalDateTime now = LocalDateTime.now();
//            String gioDen = dtf.format(now);
//            String createSoHoaDon = dtf1.format(now);
//            if (soHoaDon.equals("null")) {
//                soHoaDon = createSoHoaDon;
//                BanDAL.updateTrangThaiVaSoHoaDon(selectBan, soHoaDon, 3);
//                HoaDon hd = new HoaDon(createSoHoaDon, gioDen, new BigDecimal(0), new BigDecimal(0), LoginBLL.manv, 0, selectBan);
//                HoaDonBLL.addHoaDon(hd);
//            }
            //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //.out.println(gioDen);
            JdOrder jd = new JdOrder(this, true);
            jd.setVisible(true);
            loadDuLieuVaoTabelGoiMon();
            // FillBan();

        }

    }//GEN-LAST:event_lblIconOrderMousePressed

    private void lblIconThanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconThanhToanMousePressed
        if (trangThaiBan == 3) {
            int kq = JOptionPane.showConfirmDialog(null, "Bạn Muốn Thanh Toán " + tenBan + " ?", "Phần Mềm Quản Lý Quán Cafe", JOptionPane.YES_NO_OPTION);
            if (kq == 0) {
                if (trangThaiBan == 3 && selectBan != 0) {
                    BanDAL.updateTrangThaiVaSoHoaDon(selectBan, null, 1);
                    FillBan();
                }
            }
        }


    }//GEN-LAST:event_lblIconThanhToanMousePressed

    private void jLabel105MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel105MousePressed
        int kq = JOptionPane.showConfirmDialog(null, "Đăng Xuất ?", "Phần Mềm Quản Lý Quán Cafe", JOptionPane.YES_NO_OPTION);
        if (kq == 0) {
            frmDangNhap frm = new frmDangNhap();
            this.dispose();
            frm.show();
            LoginBLL.manv = 0;
            LoginBLL.matkhau = null;
            LoginBLL.quyen = 0;
        }
    }//GEN-LAST:event_jLabel105MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        exit("Thoát Chương Trình ?");
    }//GEN-LAST:event_jLabel1MousePressed

    private void tblGoiMonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGoiMonMouseReleased

        int r = tblGoiMon.rowAtPoint(evt.getPoint());
        if (r >= 0 && r < tblGoiMon.getRowCount()) {
            tblGoiMon.setRowSelectionInterval(r, r);
        } else {
            tblGoiMon.clearSelection();
        }

        int rowindex = tblGoiMon.getSelectedRow();
        if (rowindex < 0) {
            return;
        }
        if (evt.isPopupTrigger() && evt.getComponent() instanceof JTable) {
            int index = tblGoiMon.getSelectedRow();
            idChiTietHoaDon = Integer.parseInt(tblGoiMon.getValueAt(index, 0).toString());
            idThucDon = Integer.parseInt(tblGoiMon.getValueAt(index, 6).toString());
            soLuong = Integer.parseInt(tblGoiMon.getValueAt(index, 3).toString());
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        }

    }//GEN-LAST:event_tblGoiMonMouseReleased

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        jdSuaMon jd = new jdSuaMon(this, true);
        jd.setVisible(true);
        loadDuLieuVaoTabelGoiMon();
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        ThucDon thucDon = ThucDonBLL.getThucDonById(frmHome.idThucDon);

        int kq = JOptionPane.showConfirmDialog(null, "Bạn Muốn Hủy Món :" + thucDon.getTenMon() + " - " + tenBan + " ?", "Phần Mềm Quản Lý Quán Cafe", JOptionPane.YES_NO_OPTION);
        if (kq == 0) {
            ChiTietHoaDonBLL.deleteChiTietHoaDon(idChiTietHoaDon);

            ChiTietHoaDonBLL.getChiTietHoaDonBySoHoaDonStr(soHoaDon);
            int tongTien = ChiTietHoaDonBLL.tongTien;
            HoaDonBLL.updateTongTienHoaDon(soHoaDon, new BigDecimal(tongTien));

        }
        updateTongTien();
        loadDuLieuVaoTabelGoiMon();
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void tblGoiMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGoiMonMouseClicked
        int index = tblGoiMon.getSelectedRow();
        idChiTietHoaDon = Integer.parseInt(tblGoiMon.getValueAt(index, 0).toString());
        idThucDon = Integer.parseInt(tblGoiMon.getValueAt(index, 6).toString());
        soLuong = Integer.parseInt(tblGoiMon.getValueAt(index, 3).toString());
    }//GEN-LAST:event_tblGoiMonMouseClicked
    public void loadDuLieuVaoTabelGoiMon() {
        ResultSet rsGetChiTietThucDonBySoHoaDon = ChiTietHoaDonBLL.getChiTietThucDonBySoHoaDon(soHoaDon);
        ChiTietHoaDonBLL.DoDuLieuVaoJTableChiTietHoaDon(rsGetChiTietThucDonBySoHoaDon, tblGoiMon);
    }

    public void updateTongTien() {
        HoaDon hoaDon = HoaDonBLL.getHoaDonBySoHoaDon(soHoaDon);
        lblTongTien.setText(hoaDon.getTongtien().toString());
        ChiTietHoaDonBLL.tongTien = 0;
    }
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * @param args the command line arguments
     */
    public static void exit(String noiDungThongBao) {

        int kq = JOptionPane.showConfirmDialog(null, "" + noiDungThongBao + "", "Phần Mềm Quản Lý Quán Cafe", JOptionPane.YES_NO_OPTION);
        if (kq == 0) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel jlbBan;
    private javax.swing.JLabel jlbIconBan;
    private javax.swing.JLabel lblDatBan;
    private javax.swing.JLabel lblGioDen;
    private javax.swing.JLabel lblIconDatBan;
    private javax.swing.JLabel lblIconOrder;
    private javax.swing.JLabel lblIconThanhToan;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlGroupBan;
    private javax.swing.JTable tblGoiMon;
    // End of variables declaration//GEN-END:variables

}
